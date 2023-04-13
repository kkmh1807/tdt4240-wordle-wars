# Wordle backend

#### Create a .env file:

Working example contents:

```
COMPOSE_PROJECT_NAME="TDT4240-Wordle"
BACKEND_PORT=3000
# Database
# Use DB_URI for running server without docker
# DB_URI = mongodb://devUser:topSecret@localhost:27017/wordle?authSource=admin
DOCKER_DATABASE_URI = mongodb://devUser:topSecret@host.docker.internal:27017/wordle?authSource=admin
MONGO_INITDB_ROOT_USERNAME="devUser"
MONGO_INITDB_ROOT_PASSWORD="topSecret"
```

#### Create a local database and run the backend with docker

⚠️ Requires docker installed ⚠️

The included docker compose will do the job.  
Run `docker compose up` from /backend
This command will:

1. Create a mongoDB instance
2. Auto import 5800 5-letter words from [this](wordlist-fixtures/words.json) fixture.
3. Run the backend Node server
