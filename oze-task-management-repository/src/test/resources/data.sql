INSERT INTO OZE.USERS(USER_ID, FIRST_NAME, LAST_NAME, EMAIL, PASSWORD)
VALUES ( random_uuid(), 'Tony', 'Starks', 'tony.starks@marvel.com','TonyStarks2025#' );

INSERT INTO OZE.TASK_TYPE(TASK_TYPE_ID, DESCRIPTION)
VALUES ( 'TASK_TYPE_BUG', 'Bug' ),
       ( 'TASK_TYPE_STORY', 'Story' );

INSERT INTO OZE.TASK(TASK_ID, TITLE, DESCRIPTION, STATUS, TASK_TYPE_ID)
VALUES ( random_uuid(), 'Some Title', 'Some Description','todo', 'TASK_TYPE_STORY' )