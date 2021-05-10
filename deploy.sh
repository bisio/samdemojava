#!/bin/bash
. vars.sh
sam deploy --s3-bucket $CF_BUCKET --stack-name sam-multi-module-il --capabilities CAPABILITY_IAM \
  --tags Activity=presales Author="Andrea Bisognin" Customer=Innominata project=innominata
