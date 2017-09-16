#!/usr/bin/env bash

set -e

# maven clean and install
mvn clean install

# export docker机器的IP
export DOCKER_IP=$(docker-machine ip $(docker-machine active))

# 如果 docker-machine 不存在，则设置默认IP
DOCKER_IP=${DOCKER_IP:-0.0.0.0}

# 移除掉已经存在的容器
docker-compose stop
docker-compose rm -f

# 启动 config-service
docker-compose up -d config-service

# while [ -z ${CONFIG_SERVICE_READY} ]; do
#  echo "Waiting for config service..."
#  if [ "$(curl --silent $DOCKER_IP:8888/health 2>&1 | grep -q '\"status\":\"UP\"'; echo $?)" = 0 ]; then
#      CONFIG_SERVICE_READY=true;
#  fi
#  sleep 2
#done

sleep 15

# 启动 eureka-service
docker-compose up -d eureka-service

#while [ -z ${DISCOVERY_SERVICE_READY} ]; do
#  echo "Waiting for discovery service..."
#  if [ "$(curl --silent $DOCKER_IP:8761/health 2>&1 | grep -q '\"status\":\"UP\"'; echo $?)" = 0 ]; then
#      DISCOVERY_SERVICE_READY=true;
#  fi
#  sleep 2
#done

sleep 15

# 启动其他服务
docker-compose up -d

# 将日志输出到光标
docker-compose logs


