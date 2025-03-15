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
    (119, 3, 'Captain Morgan Private Stock Rum', 38.25, 750, 40, 'Sweet', 'Fruity', 'Rich'),
    (210, 3, 'Papa''s Pilar Sherry Finish Dark Rum', 50.99, 750, 43, 'Woody', 'Sweet', 'Oily'),
    (211, 3, 'Siesta Key Toasted Coconut', 29.99, 750, 35, 'Fruity', 'Sweet', 'Spicy'),
    (212, 3, 'Ron Abuelo 12 Años', 71.50, 750, 40, 'Sweet', 'Rich', 'Fruity'),
    (213, 3, 'Ron Diplomático Reserva Exclusiva Rum', 63.00, 750, 40, 'Sweet', 'Rich', 'Spicy'),
    (214, 3, 'Beach House Spiced Rum', 94.99, 750, 40, 'Sweet', 'Fruity', 'Spicy'),
    -- Vodka --
    (300, 3, 'Tito''s Handmade Vodka', 37.99, 1750, 40, 'Neutral', 'Rich', 'Sweet'),
    (301, 3, 'Svedka Vodka', 26.99, 1750, 40, 'Neutral', 'Bitter', 'Spicy'),
    (302, 3, 'Grey Goose Vodka', 29.99, 750, 40, 'Neutral', 'Rich', 'Bitter'),
    (303, 3, 'Absolut Vodka', 36.99, 1750, 40, 'Grain', 'Neutral', 'Rich'),
    (304, 3, 'Ketel One Vodka', 41.99, 1750, 40, 'Grain', 'Rich', 'Bitter'),
    (305, 3, 'Smirnoff Vodka', 12.99, 750, 40, 'Neutral', 'Grain', 'Sweet'),
    (306, 3, 'Skyy Vodka', 25.99, 1750, 40, 'Neutral', 'Rich', 'Oily'),
    (307, 3, 'Stolichnaya Vodka', 18.99, 750, 40, 'Spicy', 'Grain', 'Rich'),
    (308, 3, 'Chopin Wheat Vodka', 23.09, 750, 40, 'Grain', 'Neutral', 'Rich'),
    (309, 3, 'Reyka Vodka', 19.99, 750, 40, 'Grain', 'Oily', 'Rich'),
    (310, 3, 'Russian Standard Vodka', 64.99, 750, 40, 'Grain', 'Neutral', 'Bitter'),
    (311, 3, 'Cîroc Vodka', 35.10, 750, 40, 'Neutral', 'Rich', 'Bitter'),
    (312, 3, 'Cîroc Apple', 36.50, 750, 35, 'Fruity', 'Smooth', 'Sweet'),
    (313, 3, 'Cîroc Peach', 36.50, 750, 35, 'Fruity', 'Smooth', 'Sweet'),
    (314, 3, 'Cîroc Pineapple', 36.50, 750, 35, 'Fruity', 'Smooth', 'Sweet'),
    (315, 3, 'Cîroc French Vanilla', 36.50, 750, 35, 'Vanilla', 'Smooth', 'Sweet'),
    (316, 3, 'Cîroc Coconut', 38.30, 750, 35, 'Sweet', 'Vanilla', 'Smooth'),
    (317, 3, 'Cîroc Mango', 36.50, 750, 35, 'Fruity', 'Smooth', 'Sweet'),
    (318, 3, 'Cîroc Black Raspberry', 38.30, 750, 35, 'Fruity', 'Smooth', 'Sweet'),
    (319, 3, 'Cîroc Summer Citrus', 38.30, 750, 35, 'Citrus', 'Smooth', 'Sweet'),
    (320, 3, 'Cîroc White Grape', 38.30, 750, 35, 'Fruity', 'Smooth', 'Sweet'),
    (321, 3, 'Cîroc Red Berry', 36.50, 750, 35, 'Fruity', 'Smooth', 'Sweet'),
    (322, 3, 'Cîroc Amaretto', 38.30, 750, 35, 'Rich', 'Smooth', 'Sweet'),
    (323, 3, 'Cîroc Summer Watermelon', 36.50, 750, 35, 'Fruity', 'Smooth', 'Sweet'),

    -- Rum --
    (330, 3, 'Papa''s Pilar Sherry Finish Dark Rum', 50.99, 750, 43, 'Woody', 'Sweet', 'Oily'),
    (331, 3, 'Siesta Key Toasted Coconut', 29.99, 750, 35, 'Fruity', 'Sweet', 'Spicy'),
    (332, 3, 'Ron Abuelo 12 Años', 71.50, 750, 40, 'Sweet', 'Rich', 'Fruity'),
    (333, 3, 'Ron Diplomático Reserva Exclusiva Rum', 63.00, 750, 40, 'Sweet', 'Rich', 'Spicy'),
    (334, 3, 'Beach House Spiced Rum', 94.99, 750, 40, 'Sweet', 'Fruity', 'Spicy'),
    (335, 3, 'Bumbu The Original', 45.99, 750, 35, 'Sweet', 'Rich', 'Fruity'),
    (336, 3, 'Foursquare Nobiliary', 140.00, 750, 62, 'Rich', 'Fruity', 'Spicy'),
    (337, 3, 'Appleton Estate 21 Year Limited Edition', 177.99, 750, 43, 'Woody', 'Rich', 'Spicy'),
    (338, 3, 'Appleton Estate 15 Year Black River Casks', 80.89, 750, 43, 'Rich', 'Sweet', 'Oily'),
    (339, 3, 'Captain Morgan Private Stock Rum', 38.25, 750, 40, 'Sweet', 'Fruity', 'Rich'),
    (340, 3, 'Malibu Original Rum', 28.70, 750, 21, 'Sweet', 'Rich', 'Fruity'),
    (341, 3, 'Dead Man''s Fingers Spiced Rum', 32.90, 750, 37.5, 'Sweet', 'Spicy', 'Vanilla'),
    (342, 3, 'Dead Man''s Fingers Coffee Rum', 32.90, 750, 40, 'Coffee', 'Vanilla', 'Sweet'),
    (343, 3, 'Dead Man''s Fingers Coconut Rum', 32.90, 750, 40, 'Coconut', 'Fruity', 'Vanilla'),

    -- Red Wine --
    (350, 2, 'Enrique Foster Malbec Firmado', 72.99, 750, 14.5, 'Woody', 'Tart', 'Red Fruit'),
    (351, 2, 'Harvester Cabernet Sauvignon Paso Robles', 19.99, 750, 14.5, 'Fruity', 'Spicy', 'Rich'),
    (352, 2, 'D''Autrefois Pinot Noir', 14.99, 750, 12.5, 'Fruity', 'Smooth', 'Sweet'),
    (353, 2, 'Mascota Vineyards Unanime Cabernet', 25.99, 750, 14.5, 'Floral', 'Tart', 'Tart'),
    (354, 2, 'Koskil Pinot Noir Patagonia', 16.99, 750, 13, 'Floral', 'Sweet', 'Fruity'),
    (355, 2, 'Tenuta di Renieri Chianti Classico', 19.99, 750, 14, 'Rich', 'Rich', 'Fruity'),
    (356, 2, 'Chateau de Thau Cotes de Bourg', 19.99, 750, 14, 'Fruity', 'Fruity', 'Earthy'),
    (357, 2, 'San Gregorio El Vergal Tempranillo', 12.99, 750, 14.5, 'Fruity', 'Fruity', 'Sweet'),
    (358, 2, 'Plea', 44.99, 750, 14, 'Fruity', 'Tree Fruit', 'Woody'),
    (359, 2, '1858 Merlot California', 29.99, 750, 14.9, 'Spicy', 'Spicy', 'Spicy'),
    (360, 2, 'Sangria', 15.99, 750, 11, 'Fruity', 'Sweet', 'Spicy'),

    -- Rosé Wine --
    (370, 2, 'Château Minuty Rosé Et Or', 20.00, 750, 12.5, 'Fruity', 'Floral', 'Earthy'),
    (371, 2, 'Gérard Bertrand Gris Blanc', 12.00, 750, 12.5, 'Earthy', 'Fruity', 'Neutral'),
    (372, 2, 'Mathilde Chapoutier Grand Ferrage', 18.00, 750, 13, 'Citrus', 'Dry', 'Smooth'),
    (373, 2, 'Château Puech-Haut Saint-Drézéry Tête De Bélier Rosé', 30.00, 750, 13.5, 'Rich', 'Fruity', 'Rich'),
    (374, 2, 'M de Château Minuty Rosé', 15.00, 750, 13, 'Neutral', 'Citrus', 'Smooth'),
    (375, 2, 'Château Puech-Haut Saint-Drézéry Prestige Rosé', 18.00, 750, 13, 'Fruity', 'Neutral', 'Ageing'),
    (376, 2, 'Château Sainte Roseline Cuvée Lampe De Méduse', 35.00, 750, 13, 'Smooth', 'Fruity', 'Neutral'),
    (377, 2, 'Domaines Ott ''By.Ott'' Côtes de Provence Rosé', 22.00, 750, 13, 'Fruity', 'Floral', 'Neutral'),
    (378, 2, 'Château La Tour de l''Evêque Pétale de Rosé', 40.00, 750, 14, 'Citrus', 'Fruity', 'Smooth'),
    (379, 2, 'Clos Canarelli Corse Figari Rosé', 30.00, 750, 13.5, 'Funky', 'Fruity', 'Funky'),

    -- Sparkling Wine --
    (400, 2, 'Prosecco', 21.99, 750, 11, 'Fruity', 'Floral', 'Crisp'),

    -- Gin --
    (420, 3, 'Monkey 47 Dry Gin', 65.00, 750, 47, 'Fruity', 'Herbal', 'Rich'),
    (421, 3, 'Beefeater London Dry Gin', 18.99, 750, 47, 'Spicy', 'Juniper', 'Herbal'),
    (422, 3, 'Eden Mill Love Gin', 39.99, 750, 42, 'Floral', 'Rich', 'Fruity'),
    (423, 3, 'St. George Botanivore Gin', 32.99, 750, 45, 'Floral', 'Rich', 'Herbal'),
    (424, 3, 'Hernö Juniper Cask Gin', 93.00, 750, 47, 'Juniper', 'Herbal', 'Spicy'),
    (425, 3, 'Bulrush Gin', 32.99, 750, 44, 'Rich', 'Spicy', 'Earthy'),
    (426, 3, 'Nolet''s Silver Gin', 34.99, 750, 47.6, 'Fruity', 'Floral', 'Rich'),
    (427, 3, 'Leopold''s Navy Strength American Gin', 44.00, 750, 57, 'Fruity', 'Floral', 'Spicy'),
    (428, 3, 'Plymouth Navy Strength Gin', 49.98, 750, 57, 'Fruity', 'Spicy', 'Rich'),
    (429, 3, 'Sipsmith VJOP London Dry Gin', 50.00, 750, 57.7, 'Juniper', 'Spicy', 'Fruity'),

    -- Tequila/Mezcal --
    (430, 3, 'Clase Azul Tequila Reposado', 205.00, 750, 40, 'Rich', 'Fruity', 'Spicy'),
    (431, 3, 'Don Julio 1942 Tequila', 181.00, 750, 40, 'Rich', 'Sweet', 'Spicy'),
    (432, 3, 'Casamigos Reposado Tequila', 54.00, 750, 40, 'Rich', 'Sweet', 'Spicy'),
    (433, 3, 'Patrón Silver Tequila', 51.00, 750, 40, 'Spicy', 'Tart', 'Sweet'),
    (434, 3, 'Don Julio Añejo Tequila', 53.99, 750, 40, 'Rich', 'Spicy', 'Fruity'),
    (435, 3, 'Casamigos Blanco Tequila', 49.00, 750, 40, 'Rich', 'Sweet', 'Herbal'),
    (436, 3, 'Casamigos Añejo Tequila', 61.00, 750, 40, 'Spicy', 'Sweet', 'Rich'),
    (437, 3, 'Corralejo Reposado Tequila', 33.00, 750, 40, 'Rich', 'Fruity', 'Spicy'),
    (438, 3, 'Espolòn Blanco Tequila', 29.00, 750, 40, 'Fruity', 'Umami', 'Floral'),
    (439, 3, 'Espolòn Reposado Tequila', 32.00, 750, 40, 'Fruity', 'Sweet', 'Herbal'),
    (440, 3, 'Siempre Tequila Plata', 49.99, 750, 40, 'Fruity', 'Rich', 'Sweet'),

    -- Whisky/Whiskey --
    (450, 3, 'Chivas Regal 18', 149.95, 750, 40, 'Fruity', 'Spicy', 'Rich'),
    (451, 3, 'Johnnie Walker Blue Label', 359.95, 750, 40, 'Floral', 'Sweet', 'Rich'),
    (452, 3, 'Jameson 12 year Special Reserve', 41.75, 750, 40, 'Fruity', 'Sweet', 'Full'),
    (453, 3, 'Evan Williams 1783 Small Batch Bourbon', 37.09, 750, 45, 'Rich', 'Sweet', 'Full'),
    (454, 3, 'J.P. Wiser''s Triple Barrel Rye', 34.16, 750, 45, 'Spicy', 'Sweet', 'Vanilla'),
    (455, 3, 'Jim Beam Bonded Bourbon', 29.95, 750, 50, 'Vanilla', 'Spicy', 'Sweet'),
    (456, 3, 'Jim Beam Pre-Prohibition Style Rye', 20.37, 750, 45, 'Spicy', 'Vanilla', 'Rich'),
    (457, 3, 'Stalk & Barrel Red Blend', 40.00, 750, 43, 'Vanilla', 'Spicy', 'Fruity'),
    (458, 3, 'Russell''s Reserve Single Barrel Bourbon', 71.65, 750, 55, 'Spicy', 'Sweet', 'Vanilla'),
    (459, 3, 'George Dickel 13 Year Bottled in Bond Tennessee Whisky', 51.98, 750, 50, 'Spicy', 'Sweet', 'Rich'),
    (460, 3, 'Compass Box Spice Tree', 65.33, 750, 46, 'Spicy', 'Sweet', 'Rich'),
    (461, 3, 'Stagg Jr Barrel Proof Bourbon Batch 13', 310.47, 750, 64.2, 'Full', 'Vanilla', 'Rich'),
    (462, 3, 'Wild Turkey Rare Breed Barrel Proof Bourbon', 56.90, 750, 58.4, 'Vanilla', 'Full', 'Rich'),
    (463, 3, 'Knob Creek 18 Year Bourbon', 169.99, 750, 50, 'Spicy', 'Rich', 'Full'),
    (464, 3, 'Larceny Barrel Proof Batch A124', 64.99, 750, 62.1, 'Rich', 'Full', 'Sweet'),
    (465, 3, 'Booker''s Bourbon Batch 2024-01 "Springfield Batch"', 89.99, 750, 62.25, 'Rich', 'Full', 'Sweet'),

    -- Brandy --
    (470, 3, 'Château de Montifaud Napoléon Petite Champagne Cognac', 61.81, 750, 40, 'Rich', 'Fruity', 'Sweet'),
    (471, 3, 'Caravedo Pisco Mosto Verde', 42.85, 750, 43, 'Earthy', 'Rich', 'Fruity'),
    (472, 3, 'St. George Pear Brandy', 44.25, 750, 40, 'Fruity', 'Sweet', 'Herbal'),
    (473, 3, 'Rémy Martin 1738 Accord Royal Cognac', 68.13, 750, 40, 'Fruity', 'Rich', 'Sweet'),
    (474, 3, 'Pierre Ferrand Ambre Cognac', 51.98, 750, 40, 'Fruity', 'Sweet', 'Rich'),
    (475, 3, 'Christian Drouin Sélection Calvados', 39.34, 750, 40, 'Floral', 'Tart', 'Fruity'),
    (476, 3, 'Martell VS Single Distillery', 40.04, 750, 40, 'Rich', 'Sweet', 'Fruity'),
    (477, 3, 'Martell Blue Swift', 55.49, 750, 40, 'Fruity', 'Sweet', 'Rich'),
    (478, 3, 'Copper & Kings Floodwall Apple Brandy', 39.34, 750, 50, 'Rich', 'Sweet', 'Nutty'),
    (479, 3, 'Cardenal Mendoza Solera Gran Reserva Brandy de Jerez', 44.25, 750, 40, 'Woody', 'Spicy', 'Rich'),

    -- Liqueurs/Bitters --
    (480, 3, 'Aperol', 32.70, 750, 11, 'Funky', 'Sweet', 'Tart'),
    (481, 3, 'Jagermeister', 30.35, 750, 35, 'Sweet', 'Spicy', 'Herbal'),
    (482, 3, 'Campari', 29.99, 750, 24, 'Bitter', 'Herbal', 'Citrus'),
    (483, 3, 'Fernet-Branca', 34.99, 750, 39, 'Bitter', 'Herbal', 'Spicy'),
    (484, 3, 'Chartreuse Green', 65.99, 750, 55, 'Herbal', 'Spicy', 'Sweet'),
    (485, 3, 'Chartreuse Yellow', 64.99, 750, 40, 'Herbal', 'Sweet', 'Floral'),
    (486, 3, 'Cointreau', 39.99, 750, 40, 'Citrus', 'Sweet', 'Rich'),
    (487, 3, 'Grand Marnier Cordon Rouge', 41.99, 750, 40, 'Citrus', 'Rich', 'Sweet'),
    (488, 3, 'Luxardo Maraschino', 35.99, 750, 32, 'Cherry', 'Sweet', 'Rich'),
    (489, 3, 'St-Germain Elderflower', 37.99, 750, 20, 'Floral', 'Sweet', 'Fruity'),
    (490, 3, 'Benedictine DOM', 38.99, 750, 40, 'Herbal', 'Spicy', 'Sweet'),
    (491, 3, 'Amaro Montenegro', 34.99, 750, 23, 'Herbal', 'Bitter', 'Sweet'),
    (492, 3, 'Averna Amaro', 32.99, 750, 29, 'Herbal', 'Bitter', 'Sweet'),
    (493, 3, 'Cynar', 28.99, 750, 16.5, 'Bitter', 'Herbal', 'Earthy'),
    (494, 3, 'Ramazzotti Amaro', 31.99, 750, 30, 'Herbal', 'Sweet', 'Spicy'),
    (495, 3, 'Kahlúa', 27.99, 750, 20, 'Coffee', 'Sweet', 'Rich'),
    (496, 3, 'Baileys Irish Cream', 29.99, 750, 17, 'Creamy', 'Sweet', 'Coffee'),
    (497, 3, 'Drambuie', 41.99, 750, 40, 'Honey', 'Spicy', 'Sweet'),
    (498, 3, 'Chambord', 36.99, 750, 16.5, 'Raspberry', 'Sweet', 'Rich'),
    (499, 3, 'Frangelico', 32.99, 750, 20, 'Hazelnut', 'Sweet', 'Rich'),
    (500, 3, 'Limoncello di Capri', 24.99, 750, 30, 'Citrus', 'Sweet', 'Tart'),
    (501, 3, 'Galliano L''Autentico', 32.99, 750, 42.3, 'Herbal', 'Vanilla', 'Spicy'),
    (502, 3, 'Ancho Reyes Original', 34.99, 750, 40, 'Spicy', 'Sweet', 'Herbal'),
    (503, 3, 'Licor 43', 29.99, 750, 31, 'Vanilla', 'Sweet', 'Rich'),
    (504, 3, 'Tia Maria', 29.99, 750, 20, 'Coffee', 'Sweet', 'Rich'),
    (505, 3, 'Raki (Yeni Raki)', 27.99, 750, 45, 'Anise', 'Herbal', 'Sweet'),
    (506, 3, 'Grand Marnier', 41.99, 750, 40, 'Citrus', 'Rich', 'Sweet'),
    (507, 3, 'Ouzo', 22.99, 750, 40, 'Herbal', 'Sweet', 'Anise'),

    -- Non-Alcoholic --
    (900, 4, "Heineken Non-Alcoholic 0.0", 12.95, 1980, 0.01, "Malt", "Metallic", "Bitter"),
    (901, 4, "Corona Non-Alcoholic", 11.45, 1980, 0.5, "Fruity", "Honey", "Malt"),
    (902, 4, "Guinness 0", 11.95, 440, 0.5, "Bitter", "Sweet", "Coffee"),
    (903, 4, "Clausthaler Premium Non Alcoholic", 2.20, 500, 0.01, "Neutral", "Lemon", "Grassy"),
    (904, 4, "Partake Brewing Non-Alcoholic IPA", 2.00, 355, 0.3, "Sweet", "Citrus", "Caramel"),
    (905, 4, "Partake Brewing Non-Alcoholic Pale Ale", 2.00, 355, 0.3, "Malt", "Citrus", "Dry"),
    (906, 4, "Athletic Brewing Run Wild Non-Alcoholic IPA", 13.95, 355, 0.5, "Malt", "Bitter", "Neutral"),
    (907, 4, "Nozeco Sparkling Dealcoholized", 12.95, 750, 0.01, "Fruity", "Floral", "Neutral"),
    (908, 4, "Luna De Murviedro Dealcoholized Sparkling Rose", 9.95, 750, 0.01, "Fruity", "Sweet", "Fresh"),
    (909, 4, "Nozeco Sparkling Rose Dealcoholized", 11.45, 750, 0.5, "Crisp", "Red Fruit", "Neutral"),
    (910, 4, "Henkell Dealcoholized Sparkling Wine", 11.95, 750, 0.01, "Lemon", "Honey", "Tree Fruit"),
    (911, 4, "Tarapacá Dealcoholized Sauvignon Blanc", 10.95, 750, 0.5, "Sweet", "Citrus", "Fresh"),
    (912, 4, "Ritual Zero Proof Whiskey Alternative", 42.00, 750, 0.0, "Spicy", "Sweet", "Caramel"),
    (913, 4, "Seedlip Garden 108", 51.00, 750, 0.5, "Herbal", "Citrus", "Lemon"),
    (914, 4, "Lyre's American Malt", 44.00, 750, 0.5, "Sweet", "Malt", "Spicy"),
    (915, 4, "Gruvi Dry Secco", 14.99, 750, 0.5, "Crisp", "Fruity", "Floral"),
    (916, 4, "Fre Alcohol-Removed Chardonnay", 9.99, 750, 0.5, "Fruity", "Citrus", "Smooth"),
    (917, 4, "Ariel Cabernet Sauvignon", 12.99, 750, 0.5, "Rich", "Fruity", "Earthy"),
    (918, 4, "Leitz Eins Zwei Zero Riesling", 18.50, 750, 0.0, "Fruity", "Floral", "Sweet"),
    (919, 4, "Pierre Zéro Merlot", 15.99, 750, 0.0, "Fruity", "Earthy", "Smooth"),
    (920, 4, "Surely Non-Alcoholic Sparkling Rosé", 24.99, 750, 0.5, "Fruity", "Floral", "Sweet"),
    (921, 4, "St. Regis Chardonnay", 11.99, 750, 0.5, "Fruity", "Floral", "Earthy"),
    (922, 4, "Töst Sparkling White Tea", 8.99, 750, 0.0, "Tea", "Fruity", "Floral"),
    (923, 4, "Thomson & Scott Noughty Rosé", 20.99, 750, 0.5, "Fruity", "Floral", "Sweet"),
    (924, 4, "Grüvi Bubbly Rosé", 14.99, 750, 0.5, "Fruity", "Crisp", "Floral"),
    (925, 4, "Athletic Brewing Upside Dawn Golden Ale", 12.99, 355, 0.5, "Malt", "Floral", "Crisp"),
    (926, 4, "Clausthaler Dry-Hopped Non-Alcoholic", 2.50, 500, 0.5, "Hoppy", "Malt", "Floral"),
    (927, 4, "BrewDog Nanny State", 11.99, 330, 0.5, "Hoppy", "Bitter", "Malt"),
    (928, 4, "Bravus Oatmeal Dark", 13.99, 355, 0.5, "Roasted", "Sweet", "Coffee"),
    (929, 4, "Lagunitas IPNA", 10.99, 355, 0.5, "Hoppy", "Citrus", "Malt"),
    (930, 4, "WellBeing Victory Wheat", 10.99, 355, 0.5, "Citrus", "Wheat", "Smooth"),
    (931, 4, "Erdinger Weissbier Alkoholfrei", 3.50, 500, 0.5, "Wheat", "Fruity", "Smooth"),
    (932, 4, "Suntory All-Free", 12.99, 350, 0.0, "Crisp", "Malty", "Floral"),
    (933, 4, "Seedlip Spice 94", 37.99, 750, 0.0, "Spicy", "Herbal", "Citrus"),
    (934, 4, "Ritual Zero Proof Gin Alternative", 26.99, 750, 0.0, "Juniper", "Citrus", "Floral"),
    (935, 4, "Monday Zero Alcohol Gin", 39.99, 750, 0.0, "Juniper", "Herbal", "Citrus"),
    (936, 4, "Lyre's Dry London Spirit", 35.00, 700, 0.0, "Juniper", "Spicy", "Floral"),
    (937, 4, "Free Spirits Non-Alcoholic Bourbon", 35.00, 750, 0.0, "Caramel", "Spicy", "Sweet"),
    (938, 4, "Arkay Alcohol-Free Whisky", 27.50, 750, 0.0, "Smoky", "Spicy", "Sweet"),
    (939, 4, "Fluère Spiced Cane Dark Roast", 30.00, 700, 0.0, "Spicy", "Sweet", "Woody");  

-- Non Alcoholic Data Input --
INSERT INTO non_alcoholic (id, isCarbonated, alcoholicEquivalent) VALUES
(900, TRUE, 'Beer'),
(901, TRUE, 'Beer'),
(902, FALSE, 'Beer'),
(903, FALSE, 'Beer'),
(904, TRUE, 'Beer'),
(905, TRUE, 'Beer'),
(906, TRUE, 'Beer'),
(907, TRUE, 'Wine'),
(908, TRUE, 'Wine'),
(909, TRUE, 'Wine'),
(910, TRUE, 'Wine'),
(911, TRUE, 'Wine'),
(912, FALSE, 'Spirits'),
(913, FALSE, 'Spirits'),
(914, FALSE, 'Spirits'),
(915, TRUE, 'Wine'),
(916, TRUE, 'Wine'),
(917, TRUE, 'Wine'),
(918, TRUE, 'Wine'),
(919, TRUE, 'Wine'),
(920, TRUE, 'Wine'),
(921, TRUE, 'Wine'),
(922, TRUE, 'Wine'),
(923, TRUE, 'Wine'),
(924, TRUE, 'Wine'),
(925, TRUE, 'Beer'),
(926, TRUE, 'Beer'),
(927, TRUE, 'Beer'),
(928, FALSE, 'Beer'),
(929, TRUE, 'Beer'),
(930, TRUE, 'Beer'),
(931, TRUE, 'Beer'),
(932, FALSE, 'Beer'),
(933, FALSE, 'Spirits'),
(934, FALSE, 'Spirits'),
(935, FALSE, 'Spirits'),
(936, FALSE, 'Spirits'),
(937, FALSE, 'Spirits'),
(938, FALSE, 'Spirits'),
(939, FALSE, 'Spirits');

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
(119, 5),
(450, 1), -- Chivas Regal 18
(451, 1), -- Johnnie Walker Blue Label
(452, 1), -- Jameson 12 year Special Reserve
(453, 1), -- Evan Williams 1783 Small Batch Bourbon
(454, 1), -- J.P. Wiser's Triple Barrel Rye
(455, 1), -- Jim Beam Bonded Bourbon
(456, 1), -- Jim Beam Pre-Prohibition Style Rye
(457, 1), -- Stalk & Barrel Red Blend
(458, 1), -- Russell's Reserve Single Barrel Bourbon
(459, 1), -- George Dickel 13 Year Bottled in Bond Tennessee Whisky
(460, 1), -- Compass Box Spice Tree
(461, 1), -- Stagg Jr Barrel Proof Bourbon Batch 13
(462, 1), -- Wild Turkey Rare Breed Barrel Proof Bourbon
(463, 1), -- Knob Creek 18 Year Bourbon
(464, 1), -- Larceny Barrel Proof Batch A124
(465, 1), -- Booker's Bourbon Batch 2024-01 "Springfield Batch"
(480, 3),  -- Aperol
(481, 3),  -- Jagermeister
(482, 3),  -- Campari
(483, 3),  -- Fernet-Branca
(484, 3),  -- Chartreuse Green
(485, 3),  -- Chartreuse Yellow
(486, 3),  -- Cointreau
(487, 3),  -- Grand Marnier Cordon Rouge
(488, 3),  -- Luxardo Maraschino
(489, 3),  -- St-Germain Elderflower
(490, 3),  -- Benedictine DOM
(491, 3),  -- Amaro Montenegro
(492, 3),  -- Averna Amaro
(493, 3),  -- Cynar
(494, 3),  -- Ramazzotti Amaro
(495, 3),  -- Kahlúa
(496, 3),  -- Baileys Irish Cream
(497, 3),  -- Drambuie
(498, 3),  -- Chambord
(499, 3),  -- Frangelico
(500, 3),  -- Limoncello di Capri
(501, 3),  -- Galliano L'Autentico
(502, 3),  -- Ancho Reyes Original
(503, 3),  -- Licor 43
(504, 3),  -- Tia Maria
(505, 3),  -- Raki (Yeni Raki)
(506, 3),  -- Grand Marnier
(507, 3);  -- Ouzo


-- Whisky Data Input --
INSERT INTO whisky(id, age, barrelType) VALUES
(100, 12, 'Oak'),
(101, NULL, 'Oak'),
(102, NULL, 'Oak'),
(103, NULL, 'Oak'),
(104, 13, 'Oak'),
(105, NULL, 'Oak'),
(106, 13, 'Oak'),
(109, NULL, 'Oak'),
(450, 18, 'Oak'), -- Chivas Regal 18
(451, NULL, 'Oak'), -- Johnnie Walker Blue Label
(452, 12, 'Oak'), -- Jameson 12 year Special Reserve
(453, NULL, 'Oak'), -- Evan Williams 1783 Small Batch Bourbon
(454, NULL, 'Oak'), -- J.P. Wiser's Triple Barrel Rye
(455, NULL, 'Oak'), -- Jim Beam Bonded Bourbon
(456, NULL, 'Oak'), -- Jim Beam Pre-Prohibition Style Rye
(457, NULL, 'Oak'), -- Stalk & Barrel Red Blend
(458, NULL, 'Oak'), -- Russell's Reserve Single Barrel Bourbon
(459, 13, 'Oak'), -- George Dickel 13 Year Bottled in Bond Tennessee Whisky
(460, NULL, 'Oak'), -- Compass Box Spice Tree
(461, NULL, 'Oak'), -- Stagg Jr Barrel Proof Bourbon Batch 13
(462, NULL, 'Oak'), -- Wild Turkey Rare Breed Barrel Proof Bourbon
(463, 18, 'Oak'), -- Knob Creek 18 Year Bourbon
(464, NULL, 'Oak'), -- Larceny Barrel Proof Batch A124
(465, 7, 'Oak'); -- Booker's Bourbon Batch 2024-01 "Springfield Batch"

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

-- Liquors Data Input --
INSERT INTO liquors(id, aroma) VALUES
(480, 'Funky'),
(481, 'Spicy'),
(482, 'Bitter'),
(483, 'Herbal'),
(484, 'Spicy'),
(485, 'Floral'),
(486, 'Citrusy'),
(487, 'Citrusy'),
(488, 'Cherry'),
(489, 'Floral'),
(490, 'Herbal'),
(491, 'Bitter'),
(492, 'Bitter'),
(493, 'Earthy'),
(494, 'Herbal'),
(495, 'Coffee'),
(496, 'Creamy'),
(497, 'Honey'),
(498, 'Raspberry'),
(499, 'Hazelnut'),
(500, 'Citrusy'),
(501, 'Vanilla'),
(502, 'Spicy'),
(503, 'Vanilla'),
(504, 'Coffee'),
(505, 'Anise'),
(506, 'Citrusy'),
(507, 'Anise');


INSERT INTO food(id, name, flavour) VALUES
(1001, 'Steak (Ribeye)', 'Beef'),
(1002, 'Filet Mignon', 'Beef'),
(1003, 'Grilled Salmon', 'Fish'),
(1004, 'Spaghetti Carbonara', 'Pasta'),
(1005, 'Sushi', 'Fish'),
(1006, 'BBQ Ribs', 'Pork'),
(1007, 'Cheese Platter (Soft & Aged)', 'Dairy'),
(1008, 'Mushroom Risotto', 'Vegetarian'),
(1009, 'Spicy Thai Curry', 'Spicy'),
(1010, 'Roasted Chicken', 'Poultry'),
(1011, 'Lobster with Butter Sauce', 'Seafood'),
(1012, 'Beef Tacos', 'Beef'),
(1013, 'Vegetarian Mezze Platter', 'Vegetarian'),
(1014, 'Lamb Shank', 'Lamb'),
(1015, 'Margherita Pizza', 'Vegetarian'),
(1016, 'Oysters', 'Seafood'),
(1017, 'Dark Chocolate Cake', 'Dessert'),
(1018, 'Pad Thai', 'Spicy'),
(1019, 'Duck à l’Orange', 'Poultry'),
(1020, 'Grilled Vegetables', 'Vegetarian'),
(1021, 'Charcuterie Board', 'Meat & Cheese'),
(1022, 'Grilled Shrimp', 'Seafood'),
(1023, 'Cheesecake', 'Dessert'),
(1024, 'Roast Duck', 'Poultry'),
(1025, 'Indian Butter Chicken', 'Spicy'),
(1026, 'Falafel', 'Vegetarian'),
(1027, 'Beef Stroganoff', 'Beef'),
(1028, 'Fried Calamari', 'Seafood'),
(1029, 'Beef Burger', 'Beef'),
(1030, 'Caesar Salad', 'Vegetarian'),
(1031, 'Tiramisu', 'Dessert'),
(1032, 'Prosciutto & Melon', 'Meat & Fruit'),
(1033, 'Beef Wellington', 'Beef'),
(1034, 'Eggplant Parmesan', 'Vegetarian'),
(1035, 'Biryani (Chicken)', 'Spicy'),
(1036, 'Tuna Tartare', 'Fish'),
(1037, 'Paella (Seafood)', 'Seafood'),
(1038, 'Shakshuka', 'Vegetarian'),
(1039, 'Cheeseburger', 'Beef'),
(1040, 'Brisket', 'Beef'),
(1041, 'Caprese Salad', 'Vegetarian'),
(1042, 'Grilled Portobello Mushroom', 'Vegetarian'),
(1043, 'Korean Fried Chicken', 'Poultry'),
(1044, 'Ceviche', 'Seafood'),
(1045, 'Pork Schnitzel', 'Pork'),
(1046, 'French Onion Soup', 'Soup'),
(1047, 'Chocolate Lava Cake', 'Dessert'),
(1048, 'Spicy Ramen', 'Spicy'),
(1049, 'Chicken Souvlaki', 'Poultry'),
(1050, 'Stuffed Bell Peppers', 'Vegetarian'),
(1051, 'Mango Sticky Rice', 'Dessert');

INSERT INTO pairing_table(id, category_id, food_id, recommend_rank, match_flavour) VALUES
(10001, 2, 1001, 1, 'Rich, Spicy'),
(10002, 1, 1001, 2,  'Rich, Full');

