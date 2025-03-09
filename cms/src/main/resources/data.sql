-- Alcohol Categories --
INSERT INTO category(category_id, category_name) VALUES
(1, 'Beer'),
(2, 'Wine'),
(3, 'Spirit'),
(4, 'Non-Alcoholic');

-- Spirit Types --
INSERT INTO spirit_type(id, name) VALUES
(1, 'Whiskey'),
(2, 'Brandy'),
(3, 'Liquors'),
(4, 'Tequila'),
(5, 'Rum'),
(6, 'Vodka');

-- Wine Types --
INSERT INTO wine_type(id, name) VALUES
(1, 'White'),
(2, 'Sparkling'),
(3, 'Red'),
(4, 'Rose');


INSERT INTO alcohol(id, category_id, name, price, amount, abv, top1Flavor, top2Flavor, top3Flavor)
VALUES
    -- Beers --
    (1, 1, 'Corona Extra', 17.95, 330, 4.6, 'Fruity', 'Honey', 'Malt'),
    (2, 1, 'Heineken', 17.50, 330, 5, 'Malt', 'Metallic', 'Bitter'),
    (3, 1, 'Stella Artois', 3.85, 473, 5, 'Malt', 'Floral', 'Bitter'),
    (4, 1, 'Guinness', 3.55, 500, 4.2, 'Bitter', 'Roasted', 'Sweet'),
    (5, 1, 'Budweiser', 2.95, 473, 5, 'Sweet', 'Bitter', 'Malt'),
    (6, 1, 'Bud Light', 15.05, 341, 4.2, 'Fruity', 'Smooth', 'Malt'),
    (7, 1, 'Coors Light', 14.25, 355, 4.2, 'Watery', 'Bitter', 'Malt'),
    (8, 1, 'Miller Lite', 15.25, 355, 4.17, 'Malt', 'Fruity', 'Dry'),
    (9, 1, 'Heineken Non-alcoholic 0.0', 12.95, 330, 0.01, 'Malt', 'Metallic', 'Bitter'),
    (10, 1, 'Corona Non-Alcoholic', 11.45, 330, 0.5, 'Fruity', 'Honey', 'Malt'),
    -- Wines --
    (21, 2, '21 Gables Chenin Blanc', 38.99, 750, 14.5, 'Fruity', 'Floral', 'Honey'),
    (22, 2, 'I Frati Lugana', 34.99, 750, 13, 'Citrus', 'Mineral', 'Floral'),
    (23, 2, 'El Enemigo', 39.99, 750, 13.5, 'Nutty', 'Creamy', 'Tropical'),
    (24, 2, 'Pouilly-Fuissé Tête de Cuvée', 54.99, 750, 12, 'Buttery', 'Citrus', 'Oak'),
    (25, 2, 'Jacobs Creek Moscato', 15.40, 750, 7.5, 'Sweet', 'Fruity', 'Floral'),
    (26, 2, 'Bread & Butter Chardonnay Napa 2022', 20.30, 750, 13.5, 'Vanilla', 'Oak', 'Apple'),
    (27, 2, 'Babich Black Label Marlborough 2022', 22.00, 750, 12, 'Herbaceous', 'Citrus', 'Floral'),
    (28, 2, 'Alois Lageder Pinot Grigio Dolomiti Terra Alpina 2023', 21.35, 750, 12.5, 'Crisp', 'Apple', 'Pear'),
    (29, 2, 'Santa Margherita Pinot Grigio 2023', 11.95, 375, 12.5, 'Dry', 'Citrus', 'Mineral'),
    (30, 2, 'Decoy Sauvignon Blanc Sonoma County 2021', 32.50, 750, 13.9, 'Grapefruit', 'Herbaceous', 'Tropical'),
    (31, 2, 'Castello della Sala Cervaro 2022', 115.75, 750, 12.5, 'Elegant', 'Citrus', 'Toasted Almond'),
    (32, 2, 'Carte Jaune Champagne', 79.99, 750, 12, 'Toasty', 'Citrus', 'Nutty'),
    (33, 2, 'Moët & Chandon Impérial Brut Champagne', 72.99, 750, 12, 'Apple', 'Brioche', 'Mineral'),
    (34, 2, 'Bollinger Special Cuvée Brut Aÿ Champagne', 107.99, 750, 12, 'Full-bodied', 'Nutty', 'Toasty'),
    (35, 2, 'Laurent-Perrier La Cuvée Brut Champagne', 87.99, 750, 12, 'Crisp', 'Citrus', 'Floral'),
    (36, 2, 'Réserve Champagne', 89.99, 750, 12, 'Delicate', 'Citrus', 'Toasty'),
    (37, 2, 'Perrier-Jouët Grand Brut Champagne', 84.99, 750, 12, 'Floral', 'Apple', 'Honey'),
    (38, 2, 'Billecart-Salmon Brut Réserve Champagne', 85.99, 750, 12, 'Elegant', 'Pear', 'Mineral'),
    (39, 2, 'Laurent-Perrier Cuvée Rosé', 119.99, 750, 12, 'Berry', 'Floral', 'Crisp'),
    (40, 2, 'G.H. Mumm (Cordon Rouge) Brut Champagne', 79.99, 750, 12, 'Citrus', 'Toasty', 'Honey'),
    -- Whisky --
    (100, 3, 'Jameson 12 year Special Reserve', 41.75, 750, 40, 'Fruity', 'Sweet', 'Full'),
    (101, 3, 'Evan Williams 1783 Small Batch Bourbon', 37.09, 750, 45, 'Oak', 'Rich', 'Full'),
    (102, 3, 'J.P. Wisers Triple Barrel Rye', 34.16, 750, 45, 'Oak', 'Spicy', 'Vanilla'),
    (103, 3, 'Jim Beam Bonded Bourbon', 29.95, 750, 50, 'Oak', 'Vanilla', 'Sweet'),
    (104, 3, 'Jim Beam Pre-Prohibition Style Rye', 20.37, 750, 45, 'Oak', 'Spicy', 'Rich'),
    (105, 3, 'Stalk & Barrel Red Blend', 40.00, 750, 43, 'Oak', 'Vanilla', 'Fruity'),
    (106, 3, 'Russells Reserve Single Barrel Bourbon', 71.65, 750, 55, 'Oak', 'Spicy', 'Vanilla'),
    (109, 3, 'Stagg Jr Barrel Proof Bourbon Batch 13', 310.47, 750, 64.2, 'Oak', 'Vanilla', 'Rich'),
    -- Rum --
    (110, 3, 'Papas Pilar Sherry Finish Dark Rum', 50.99, 750, 43, 'Woody', 'Sweet', 'Oily'),
    (111, 3, 'Siesta Key Toasted Coconut', 29.99, 750, 35, 'Fruity', 'Sweet', 'Spicy'),
    (112, 3, 'Ron Abuelo 12 Años', 71.50, 750, 40, 'Sweet', 'Rich', 'Fruity'),
    (113, 3, 'Ron Diplomático Reserva Exclusiva Rum', 63.00, 750, 40, 'Sweet', 'Rich', 'Spicy'),
    (114, 3, 'Beach House Spiced Rum', 94.99, 750, 40, 'Sweet', 'Fruity', 'Spicy'),
    (115, 3, 'Bumbu The Original', 45.99, 750, 35, 'Sweet', 'Rich', 'Fruity'),
    (116, 3, 'Foursquare Nobiliary', 140.00, 750, 62, 'Rich', 'Fruity', 'Spicy'),
    (117, 3, 'Appleton Estate 21 Year Limited Edition', 177.99, 750, 43, 'Woody', 'Rich', 'Spicy'),
    (118, 3, 'Appleton Estate 15 Year Black River Casks', 80.89, 750, 43, 'Rich', 'Sweet', 'Oily'),
    (119, 3, 'Captain Morgan Private Stock Rum', 38.25, 750, 40, 'Sweet', 'Fruity', 'Rich');


-- Beer Data Input --
INSERT INTO beer(id, beerType, beerOrigin) VALUES
(1, 'Pale Lagers', 'Mexico City, Mexico'),
(2, 'Pale Lagers', 'Amsterdam, Netherlands'),
(3, 'Pale Lagers', 'Leuven, Belgium'),
(4, 'Stouts', 'Dublin, Ireland'),
(5, 'Pale Lagers', 'Missouri, USA'),
(6, 'Pale Lagers', 'Missouri, USA'),
(7, 'Pale Lagers', 'Colorado, USA'),
(8, 'Pale Lagers', 'Wisconsin, USA'),
(9, 'Non-alcoholic Beer', 'Amsterdam, Netherlands'),
(10, 'Non-alcoholic Beer', 'Mexico City, Mexico');

-- Wine Data Input --
-- (1, 'White'),
-- (2, 'Sparkling'),
-- (3, 'Red'),
-- (4, 'Rose');
INSERT INTO wine(id, wine_type_id, age) VALUES
(21, 1, 5),
(22, 1, 2),
(23, 1, 5),
(24, 1, 4),
(25, 1, 2),
(26, 1, 3),
(27, 1, 3),
(28, 1, 2),
(29, 1, 2),
(30, 1, 4),
(31, 1, 3),
(32, 2, NULL),
(33, 2, NULL),
(34, 2, NULL),
(35, 2, NULL),
(36, 2, NULL),
(37, 2, NULL),
(38, 2, NULL),
(39, 2, NULL),
(40, 2, NULL);

-- Spirit Data Input --
-- (1, 'Whiskey'),
-- (2, 'Brandy'),
-- (3, 'Liquors'),
-- (4, 'Tequila'),
-- (5, 'Rum'),
-- (6, 'Vodka');
INSERT INTO spirit(id, spirit_type_id) VALUES
(100, 1),
(101, 1),
(102, 1),
(103, 1),
(104, 1),
(105, 1),
(106, 1),
(109, 1),
(110, 5),
(111, 5),
(112, 5),
(113, 5),
(114, 5),
(115, 5),
(116, 5),
(117, 5),
(118, 5),
(119, 5);

-- Whisky Data Input --
INSERT INTO whisky(id, age, barrelType) VALUES
(100, 12, 'Oak'),
(101, NULL, 'Oak'),
(102, NULL, 'Oak'),
(103, NULL, 'Oak'),
(104, 13, 'Oak'),
(105, NULL, 'Oak'),
(106, 13, 'Oak'),
(109, NULL, 'Oak');

-- Rum Data Input --
INSERT INTO rum(id, flavour) VALUES
(110, 'Hazelnut'),
(111, 'Coconut'),
(112, 'Caramel'),
(113, 'Dart Fruit'),
(114, 'Dark Chocolate'),
(115, 'Vanilla'),
(116, 'Vanilla'),
(117, 'Caramel');