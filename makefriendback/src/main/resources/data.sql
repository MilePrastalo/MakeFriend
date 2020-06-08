INSERT INTO user (`id`, `email`, `first_name`, `last_name`, `password`, `username`) VALUES ('100', 'pera@pera.com', 'pera', 'peric', '$2a$10$PxvKsblywCsPRpmccc2Id.Vf5bMDvXfRMxUhmhhAL1gxXLcWDAhIa', 'peric');
INSERT INTO user (`id`, `email`, `first_name`, `last_name`, `password`, `username`) VALUES ('200', 'mika@mika.com', 'mika', 'mikic', '$2a$10$PxvKsblywCsPRpmccc2Id.Vf5bMDvXfRMxUhmhhAL1gxXLcWDAhIa', 'mika');
INSERT INTO user (`id`, `email`, `first_name`, `last_name`, `password`, `username`) VALUES ('300', 'laza@laza.com', 'laza', 'lazic', '$2a$10$PxvKsblywCsPRpmccc2Id.Vf5bMDvXfRMxUhmhhAL1gxXLcWDAhIa', 'laza');

INSERT INTO authority (`id`, `name`) VALUES ('100', 'USER');
INSERT INTO authority (`id`, `name`) VALUES ('200', 'ADMIN');
insert into user_authorities (user_id,authorities_id) values(100,200);
insert into user_authorities (user_id,authorities_id) values(100,100);

INSERT INTO interest_category (`id`, `name`) VALUES ('100', 'SPORT');
INSERT INTO interest_category (`id`, `name`) VALUES ('200', 'TVMOVIE');
INSERT INTO interest_category (`id`, `name`) VALUES ('300', 'BOOKS');
INSERT INTO interest_category (`id`, `name`) VALUES ('400', 'MUSIC');

INSERT INTO interest (`id`, `name`, `category_id`) VALUES ('100', 'Football', '100');
INSERT INTO interest (`id`, `name`, `category_id`) VALUES ('200', 'Basketball', '100');
INSERT INTO interest (`id`, `name`, `category_id`) VALUES ('300', 'Volleyball', '100');
INSERT INTO interest (`id`, `name`, `category_id`) VALUES ('400', 'TV Shows', '200');
INSERT INTO interest (`id`, `name`, `category_id`) VALUES ('500', 'Movies', '200');
INSERT INTO interest (`id`, `name`, `category_id`) VALUES ('600', 'FantasyBooks', '300');
INSERT INTO interest (`id`, `name`, `category_id`) VALUES ('700', 'DramaBooks', '300');
INSERT INTO interest (`id`, `name`, `category_id`) VALUES ('800', 'PoetryBooks', '300');
INSERT INTO interest (`id`, `name`, `category_id`) VALUES ('900', 'DetectiveBooks', '300');
INSERT INTO interest (`id`, `name`, `category_id`) VALUES ('1000', 'HistoryBooks', '300');
INSERT INTO interest (`id`, `name`, `category_id`) VALUES ('1100', 'Hip-hop', '400');
INSERT INTO interest (`id`, `name`, `category_id`) VALUES ('1200', 'Rock', '400');
INSERT INTO interest (`id`, `name`, `category_id`) VALUES ('1300', 'Metal', '400');
INSERT INTO interest (`id`, `name`, `category_id`) VALUES ('1400', 'Pop', '400');

INSERT INTO interest_category_interests (`interest_category_id`, `interests_id`) VALUES ('100', '100');
INSERT INTO interest_category_interests (`interest_category_id`, `interests_id`) VALUES ('100', '200');
INSERT INTO interest_category_interests (`interest_category_id`, `interests_id`) VALUES ('100', '300');
INSERT INTO interest_category_interests (`interest_category_id`, `interests_id`) VALUES ('200', '400');
INSERT INTO interest_category_interests (`interest_category_id`, `interests_id`) VALUES ('200', '500');
INSERT INTO interest_category_interests (`interest_category_id`, `interests_id`) VALUES ('300', '600');
INSERT INTO interest_category_interests (`interest_category_id`, `interests_id`) VALUES ('300', '700');
INSERT INTO interest_category_interests (`interest_category_id`, `interests_id`) VALUES ('300', '800');
INSERT INTO interest_category_interests (`interest_category_id`, `interests_id`) VALUES ('300', '900');
INSERT INTO interest_category_interests (`interest_category_id`, `interests_id`) VALUES ('300', '1000');
INSERT INTO interest_category_interests (`interest_category_id`, `interests_id`) VALUES ('400', '1100');
INSERT INTO interest_category_interests (`interest_category_id`, `interests_id`) VALUES ('400', '1200');
INSERT INTO interest_category_interests (`interest_category_id`, `interests_id`) VALUES ('400', '1300');
INSERT INTO interest_category_interests (`interest_category_id`, `interests_id`) VALUES ('400', '1400');


INSERT INTO user_interests (`user_id`, `interests_id`) VALUES ('100', '100');
INSERT INTO user_interests (`user_id`, `interests_id`) VALUES ('100', '200');
INSERT INTO user_interests (`user_id`, `interests_id`) VALUES ('100', '300');
INSERT INTO user_interests (`user_id`, `interests_id`) VALUES ('100', '400');
INSERT INTO user_interests (`user_id`, `interests_id`) VALUES ('200', '100');
INSERT INTO user_interests (`user_id`, `interests_id`) VALUES ('200', '600');
INSERT INTO user_interests (`user_id`, `interests_id`) VALUES ('200', '700');
INSERT INTO user_interests (`user_id`, `interests_id`) VALUES ('200', '800');
INSERT INTO user_interests (`user_id`, `interests_id`) VALUES ('200', '900');
INSERT INTO user_interests (`user_id`, `interests_id`) VALUES ('300', '100');
INSERT INTO user_interests (`user_id`, `interests_id`) VALUES ('300', '200');

INSERT INTO trait (`id`, `name`) VALUES ('100', 'Smoking');
INSERT INTO trait (`id`, `name`) VALUES ('200', 'Drinks');
INSERT INTO trait (`id`, `name`) VALUES ('300', 'Active');
INSERT INTO trait (`id`, `name`) VALUES ('400', 'University');

INSERT INTO user_trait (id, value, trait_id) VALUES (100, 1, 100);
INSERT INTO user_trait (id, value, trait_id) VALUES (200, 1, 200);
INSERT INTO user_trait (id, value, trait_id) VALUES (300, 0, 300);
INSERT INTO user_trait (id, value, trait_id) VALUES (400, 0, 400);
INSERT INTO user_trait (id, value, trait_id) VALUES (500, 1, 100);
INSERT INTO user_trait (id, value, trait_id) VALUES (600, 1, 200);
INSERT INTO user_trait (id, value, trait_id) VALUES (700, 0, 300);
INSERT INTO user_trait (id, value, trait_id) VALUES (800, 0, 400);
INSERT INTO user_trait (id, value, trait_id) VALUES (900,0, 100);
INSERT INTO user_trait (id, value, trait_id) VALUES (1000, 0, 200);
INSERT INTO user_trait (id, value, trait_id) VALUES (1100, 1, 300);
INSERT INTO user_trait (id, value, trait_id) VALUES (1200, 1, 400);


INSERT INTO user_traits (`user_id`, `traits_id`) VALUES ('100', '100');
INSERT INTO user_traits (`user_id`, `traits_id`) VALUES ('100', '200');
INSERT INTO user_traits (`user_id`, `traits_id`) VALUES ('100', '300');
INSERT INTO user_traits (`user_id`, `traits_id`) VALUES ('100', '400');
INSERT INTO user_traits (`user_id`, `traits_id`) VALUES ('200', '500');
INSERT INTO user_traits (`user_id`, `traits_id`) VALUES ('200', '600');
INSERT INTO user_traits (`user_id`, `traits_id`) VALUES ('200', '700');
INSERT INTO user_traits (`user_id`, `traits_id`) VALUES ('200', '800');
INSERT INTO user_traits (`user_id`, `traits_id`) VALUES ('300', '900');
INSERT INTO user_traits (`user_id`, `traits_id`) VALUES ('300', '1000');
INSERT INTO user_traits (`user_id`, `traits_id`) VALUES ('300', '1100');
INSERT INTO user_traits (`user_id`, `traits_id`) VALUES ('300', '1200');
