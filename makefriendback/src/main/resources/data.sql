INSERT INTO user (`id`, `email`, `first_name`, `last_name`, `password`, `username`) VALUES ('1', 'pera@pera.com', 'pera', 'peric', '$2a$10$PxvKsblywCsPRpmccc2Id.Vf5bMDvXfRMxUhmhhAL1gxXLcWDAhIa', 'peric');
INSERT INTO user (`id`, `email`, `first_name`, `last_name`, `password`, `username`) VALUES ('2', 'mika@mika.com', 'mika', 'mikic', '$2a$10$PxvKsblywCsPRpmccc2Id.Vf5bMDvXfRMxUhmhhAL1gxXLcWDAhIa', 'mika');
INSERT INTO user (`id`, `email`, `first_name`, `last_name`, `password`, `username`) VALUES ('3', 'laza@laza.com', 'laza', 'lazic', '$2a$10$PxvKsblywCsPRpmccc2Id.Vf5bMDvXfRMxUhmhhAL1gxXLcWDAhIa', 'laza');
INSERT INTO authority (`id`, `name`) VALUES ('1', 'USER');

INSERT INTO interest_category (`id`, `name`) VALUES ('1', 'SPORT');
INSERT INTO interest_category (`id`, `name`) VALUES ('2', 'TVMOVIE');
INSERT INTO interest_category (`id`, `name`) VALUES ('3', 'BOOKS');
INSERT INTO interest_category (`id`, `name`) VALUES ('4', 'MUSIC');

INSERT INTO interest (`id`, `name`, `category_id`) VALUES ('1', 'Football', '1');
INSERT INTO interest (`id`, `name`, `category_id`) VALUES ('2', 'Basketball', '1');
INSERT INTO interest (`id`, `name`, `category_id`) VALUES ('3', 'Volleyball', '1');
INSERT INTO interest (`id`, `name`, `category_id`) VALUES ('4', 'TV Shows', '2');
INSERT INTO interest (`id`, `name`, `category_id`) VALUES ('5', 'Movies', '2');
INSERT INTO interest (`id`, `name`, `category_id`) VALUES ('6', 'FantasyBooks', '3');
INSERT INTO interest (`id`, `name`, `category_id`) VALUES ('7', 'DramaBooks', '3');
INSERT INTO interest (`id`, `name`, `category_id`) VALUES ('8', 'PoetryBooks', '3');
INSERT INTO interest (`id`, `name`, `category_id`) VALUES ('9', 'DetectiveBooks', '3');
INSERT INTO interest (`id`, `name`, `category_id`) VALUES ('10', 'HistoryBooks', '3');
INSERT INTO interest (`id`, `name`, `category_id`) VALUES ('11', 'Hip-hop', '4');
INSERT INTO interest (`id`, `name`, `category_id`) VALUES ('12', 'Rock', '4');
INSERT INTO interest (`id`, `name`, `category_id`) VALUES ('13', 'Metal', '4');
INSERT INTO interest (`id`, `name`, `category_id`) VALUES ('14', 'Pop', '4');

INSERT INTO interest_category_interests (`interest_category_id`, `interests_id`) VALUES ('1', '1');
INSERT INTO interest_category_interests (`interest_category_id`, `interests_id`) VALUES ('1', '2');
INSERT INTO interest_category_interests (`interest_category_id`, `interests_id`) VALUES ('1', '3');
INSERT INTO interest_category_interests (`interest_category_id`, `interests_id`) VALUES ('2', '4');
INSERT INTO interest_category_interests (`interest_category_id`, `interests_id`) VALUES ('2', '5');
INSERT INTO interest_category_interests (`interest_category_id`, `interests_id`) VALUES ('3', '6');
INSERT INTO interest_category_interests (`interest_category_id`, `interests_id`) VALUES ('3', '7');
INSERT INTO interest_category_interests (`interest_category_id`, `interests_id`) VALUES ('3', '8');
INSERT INTO interest_category_interests (`interest_category_id`, `interests_id`) VALUES ('3', '9');
INSERT INTO interest_category_interests (`interest_category_id`, `interests_id`) VALUES ('3', '10');
INSERT INTO interest_category_interests (`interest_category_id`, `interests_id`) VALUES ('4', '11');
INSERT INTO interest_category_interests (`interest_category_id`, `interests_id`) VALUES ('4', '12');
INSERT INTO interest_category_interests (`interest_category_id`, `interests_id`) VALUES ('4', '13');
INSERT INTO interest_category_interests (`interest_category_id`, `interests_id`) VALUES ('4', '14');


INSERT INTO user_interests (`user_id`, `interests_id`) VALUES ('1', '1');
INSERT INTO user_interests (`user_id`, `interests_id`) VALUES ('1', '2');
INSERT INTO user_interests (`user_id`, `interests_id`) VALUES ('1', '3');
INSERT INTO user_interests (`user_id`, `interests_id`) VALUES ('1', '4');
INSERT INTO user_interests (`user_id`, `interests_id`) VALUES ('2', '1');
INSERT INTO user_interests (`user_id`, `interests_id`) VALUES ('2', '6');
INSERT INTO user_interests (`user_id`, `interests_id`) VALUES ('2', '7');
INSERT INTO user_interests (`user_id`, `interests_id`) VALUES ('2', '8');
INSERT INTO user_interests (`user_id`, `interests_id`) VALUES ('2', '9');
INSERT INTO user_interests (`user_id`, `interests_id`) VALUES ('3', '1');
INSERT INTO user_interests (`user_id`, `interests_id`) VALUES ('3', '2');

INSERT INTO trait (`id`, `name`) VALUES ('1', 'Smoking');
INSERT INTO trait (`id`, `name`) VALUES ('2', 'Drinks');
INSERT INTO trait (`id`, `name`) VALUES ('3', 'Active');
INSERT INTO trait (`id`, `name`) VALUES ('4', 'University');

INSERT INTO user_trait (id, value, trait_id) VALUES (1, 1, 1);
INSERT INTO user_trait (id, value, trait_id) VALUES (2, 1, 2);
INSERT INTO user_trait (id, value, trait_id) VALUES (3, 0, 3);
INSERT INTO user_trait (id, value, trait_id) VALUES (4, 0, 4);
INSERT INTO user_trait (id, value, trait_id) VALUES (5, 1, 1);
INSERT INTO user_trait (id, value, trait_id) VALUES (6, 1, 2);
INSERT INTO user_trait (id, value, trait_id) VALUES (7, 0, 3);
INSERT INTO user_trait (id, value, trait_id) VALUES (8, 0, 4);
INSERT INTO user_trait (id, value, trait_id) VALUES (9,0, 1);
INSERT INTO user_trait (id, value, trait_id) VALUES (10, 0, 2);
INSERT INTO user_trait (id, value, trait_id) VALUES (11, 1, 3);
INSERT INTO user_trait (id, value, trait_id) VALUES (12, 1, 4);


INSERT INTO user_traits (`user_id`, `traits_id`) VALUES ('1', '1');
INSERT INTO user_traits (`user_id`, `traits_id`) VALUES ('1', '2');
INSERT INTO user_traits (`user_id`, `traits_id`) VALUES ('1', '3');
INSERT INTO user_traits (`user_id`, `traits_id`) VALUES ('1', '4');
INSERT INTO user_traits (`user_id`, `traits_id`) VALUES ('2', '5');
INSERT INTO user_traits (`user_id`, `traits_id`) VALUES ('2', '6');
INSERT INTO user_traits (`user_id`, `traits_id`) VALUES ('2', '7');
INSERT INTO user_traits (`user_id`, `traits_id`) VALUES ('2', '8');
INSERT INTO user_traits (`user_id`, `traits_id`) VALUES ('3', '9');
INSERT INTO user_traits (`user_id`, `traits_id`) VALUES ('3', '10');
INSERT INTO user_traits (`user_id`, `traits_id`) VALUES ('3', '11');
INSERT INTO user_traits (`user_id`, `traits_id`) VALUES ('3', '12');
