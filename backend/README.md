# Wordle backend

### How to start

Run `npm install`from the backend folder

#### Create a .env file:

Working example contents:

```
COMPOSE_PROJECT_NAME="TDT4240-Wordle"
BACKEND_PORT=3000
# Database
DB_URI = mongodb://devUser:topSecret@localhost:27017/wordle?authSource=admin
DOCKER_DATABASE_URI = mongodb://host.docker.internal:27017/wordle?authSource=admin
MONGO_INITDB_ROOT_USERNAME="devUser"
MONGO_INITDB_ROOT_PASSWORD="topSecret"
```

#### Create a local database

⚠️ Requires docker installed ⚠️

The included docker compose will do the job,  
run the given shortcut `npm run db`.  
This will also auto import 5800 5-letter words from [this](wordlist-fixtures/words.json) fixture.

#### Start the express-server

`npm run dev`
