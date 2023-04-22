# Wordle Wars

Wordle wars is a game for people wanting wo compete by solving the most wordle-challenges in the shortest amount of time. If you guess a letter in the word, but it's placed wrong the letter will be highlighted in yellow, and if it has the correct placement it will be highlighted in green. No highlight means the word do not contain the letter. You can only guess english legal 5-letter words.

## How to run compile/run project

Before starting:

- Install Android Studio (frontend)
- Install Docker / Docker desktop (backend) (not necessary if using the hosted backend while connected to eduroam)
- git clone this repo

## Frontend

1. Open only the /frontend folder in andriod studio.

Now you got two options:

#### If you want to run on an android phone:

2. Click on the build tab -> Build Bundle(s) / APK(s) --> Build APK(s)
3. Transfer the file you got from the last step to an android phone
4. Install the application
5. Open the Wordle Wars

#### Or using an emulator:

1. Create an android emulator with your desired android version.
2. Run the game from android studio.

NOTE: If you are on eduroam and do not do changes on the backend you can keep the BASE_URL = "http://10.212.25.104:8080" in ScoreApiService and WordApiService in the network-folder to use the hosted backend. If you need to run the backend locally you need to edit this URL.

## Backend

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

The included docker compose will do the job.  
Run `docker compose up` from /backend
This command will:

1. Create a mongoDB instance
2. Auto import 5800 5-letter words from [this](wordlist-fixtures/words.json) fixture.
3. Run the backend Node server

Now you can access the backend by `localhost:3000`, if the example .env is not edited.
