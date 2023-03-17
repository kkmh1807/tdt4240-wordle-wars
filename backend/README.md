# Wordle backend

### How to start

Run `npm install`from the backend folder

#### Create a .env file:

Working example contents:

```
COMPOSE_PROJECT_NAME="TDT4240-Wordle"
BACKEND_PORT=3000
# Database
DB_URI = "mongodb://devUser:topSecret@localhost:27017/wordle?authSource=admin"
MONGO_INITDB_ROOT_USERNAME="devUser"
MONGO_INITDB_ROOT_PASSWORD="topSecret"
```

#### Create a local database

The included docker compose will do the job,
run the given shortcut `npm run db`.

#### Start the express-server

`npm run dev`
