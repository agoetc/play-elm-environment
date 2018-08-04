setup:
	docker-compose down
	docker-compose build
	docker-compose up -d
	cd ./play-scala-seed; \
	elm-package install -y
