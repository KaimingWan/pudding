#!/usr/bin/env bash
port=$1
sudo lsof -nP -iTCP:$1 -sTCP:LISTEN