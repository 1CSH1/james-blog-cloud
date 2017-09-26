#!/usr/bin/env bash

set -e

# maven clean and install
mvn clean install

# export docker机器的IP
export DOCKER_IP=$(docker-machine ip)

# 如果 docker-machine 不存在，则设置默认IP
DOCKER_IP=${DOCKER_IP:-0.0.0.0}

# 移除掉已经存在的容器
docker-compose stop
docker-compose rm -f

# 启动 rabbitmq
docker-compose up -d rabbitmq

# 启动 config-service
docker-compose up -d config-service

while [ -z ${CONFIG_SERVICE_READY} ]; do
  echo "Waiting for config service..."
  CONFIG_SERVICE_READY=false;
  if [ "$(curl --silent $DOCKER_IP:6001/health 2>&1 | grep -q '\"status\":\"UP\"'; echo $?)" = 0 ]; then
      CONFIG_SERVICE_READY=true;
  fi
  sleep 1
done

# 启动 eureka-service
docker-compose up -d eureka-service

while [ -z ${EUREKA_SERVICE_READY} ]; do
  echo "Waiting for eureka-service..."
  EUREKA_SERVICE_READY=false;
  if [ "$(curl --silent $DOCKER_IP:6002/health 2>&1 | grep -q '\"status\":\"UP\"'; echo $?)" = 0 ]; then
      EUREKA_SERVICE_READY=true;
  fi
  sleep 3
done

# 启动 hystrix-dashboard
docker-compose up -d hystrix-dashboard

# 启动 zipkin-service
docker-compose up -d zipkin-service


# 启动其他服务
# docker-compose up -d

# 将日志输出到光标
docker-compose logs


