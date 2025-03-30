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


INSERT INTO alcohol (id, category_id, name, price, amount, abv, top1Flavor, top2Flavor, top3Flavor)
VALUES
    -- LAGERS (More variations added)
    (600, 1, 'Corona Extra', 5.25, 330, 4.6, 'Fruity', 'Fruity', 'Sweet'),
    (601, 1, 'Heineken', 5.00, 330, 5.0, 'Fruity', 'Fruity', 'Fruity'),
    (602, 1, 'Budweiser', 4.50, 473, 5.0, 'Herbal', 'Herbal', 'Herbal'),
    (603, 1, 'Coors Banquet', 5.75, 355, 5.0, 'Woody', 'Fruity', 'Sweet'),
    (604, 1, 'Miller High Life', 4.25, 355, 4.6, 'Sweet', 'Herbal', 'Woody'),
    (605, 1, 'Asahi Super Dry', 6.00, 330, 5.0, 'Woody', 'Herbal', 'Fruity'),
    (606, 1, 'Carlsberg', 5.50, 330, 5.0, 'Fruity', 'Sweet', 'Woody'),
    (607, 1, 'Becks', 5.00, 500, 5.0, 'Woody', 'Fruity', 'Herbal'),
    (608, 1, 'Kronenbourg 1664', 6.25, 500, 5.5, 'Sweet', 'Woody', 'Fruity'),

    -- STOUTS (More flavors covered)
    (609, 1, 'Guinness', 5.25, 500, 4.2, 'Sweet', 'Fruity', 'Fruity'),
    (610, 1, 'Sierra Nevada Stout', 6.00, 355, 5.6, 'Herbal', 'Woody', 'Fruity'),
    (611, 1, 'Murphy’s Irish Stout', 5.50, 500, 4.0, 'Woody', 'Fruity', 'Sweet'),
    (612, 1, 'Samuel Smith Oatmeal Stout', 6.50, 550, 5.0, 'Sweet', 'Woody', 'Herbal'),
    (613, 1, 'Left Hand Milk Stout', 6.25, 355, 6.0, 'Herbal', 'Sweet', 'Fruity'),
    (614, 1, 'Young’s Double Chocolate Stout', 7.00, 500, 5.2, 'Sweet', 'Fruity', 'Herbal'),
    (615, 1, 'Dragon Stout', 6.75, 355, 7.5, 'Woody', 'Sweet', 'Herbal'),
    (616, 1, 'Founders Breakfast Stout', 7.25, 355, 8.3, 'Herbal', 'Woody', 'Sweet'),
    (617, 1, 'Imperial Russian Stout', 8.00, 500, 9.0, 'Sweet', 'Fruity', 'Woody'),

    -- PILSNERS
    (618, 1, 'Pilsner Urquell', 4.95, 500, 4.4, 'Herbal', 'Fruity', 'Woody'),
    (619, 1, 'Budvar', 5.75, 330, 5.0, 'Fruity', 'Woody', 'Herbal'),
    (620, 1, 'Bitburger Pils', 5.25, 500, 4.8, 'Herbal', 'Sweet', 'Woody'),
    (621, 1, 'Warsteiner', 5.50, 500, 4.8, 'Woody', 'Herbal', 'Sweet'),
    (622, 1, 'Jever Pilsner', 6.00, 500, 4.9, 'Fruity', 'Sweet', 'Woody'),
    (623, 1, 'Krombacher Pils', 5.75, 500, 4.8, 'Sweet', 'Woody', 'Fruity'),
    (624, 1, 'Spaten Pils', 5.50, 500, 5.0, 'Woody', 'Herbal', 'Fruity'),
    (625, 1, 'Stella Artois Pilsner', 5.95, 500, 5.2, 'Fruity', 'Herbal', 'Sweet'),

    -- ALES
    (626, 1, 'Pale Ale', 5.25, 355, 5.4, 'Fruity', 'Herbal', 'Sweet'),
    (627, 1, 'Hazy IPA', 6.50, 355, 6.5, 'Herbal', 'Woody', 'Fruity'),
    (628, 1, 'Lagunitas IPA', 6.25, 355, 6.2, 'Fruity', 'Herbal', 'Sweet'),
    (629, 1, 'Stone IPA', 7.00, 355, 6.9, 'Herbal', 'Sweet', 'Woody'),
    (630, 1, 'Newcastle Brown Ale', 6.00, 500, 4.7, 'Sweet', 'Fruity', 'Woody'),
    (631, 1, 'Fat Tire Amber Ale', 6.25, 355, 5.2, 'Woody', 'Sweet', 'Fruity'),
    (632, 1, 'Red Hook ESB', 6.75, 355, 5.8, 'Sweet', 'Herbal', 'Woody'),
    (633, 1, 'Sierra Nevada Pale Ale', 6.50, 355, 5.6, 'Fruity', 'Woody', 'Sweet'),
    (634, 1, 'Chimay Blue', 8.25, 330, 9.0, 'Fruity', 'Sweet', 'Woody'),
    ------------------------------------------------------------------------
    (21, 2, '21 Gables Chenin Blanc', 38.99, 750, 14.5, 'Woody', 'Fruity', 'Fruity'),
    (22, 2, 'I Frati Lugana', 34.99, 750, 13, 'Fruity', 'Sweet', 'Fruity'),
    (23, 2, 'El Enemigo', 39.99, 750, 13.5, 'Woody', 'Fruity', 'Fruity'),
    (24, 2, 'Pouilly-Fuissé Tête de Cuvée', 54.99, 750, 12, 'Fruity', 'Fruity', 'Fruity'),
    (25, 2, 'Jacobs Creek Moscato', 15.40, 750, 7.5, 'Fruity', 'Fruity', 'Sweet'),
    (26, 2, 'Bread & Butter Chardonnay Napa 2022', 20.30, 750, 13.5, 'Sweet', 'Fruity', 'Fruity'),
    (27, 2, 'Babich Black Label Marlborough 2022', 22.00, 750, 12, 'Fruity', 'Herbal', 'Woody'),
    (28, 2, 'Alois Lageder Pinot Grigio Dolomiti Terra Alpina 2023', 21.35, 750, 12.5, 'Fruity', 'Sweet', 'Fruity'),
    (29, 2, 'Santa Margherita Pinot Grigio 2023', 11.95, 375, 12.5, 'Fruity', 'Fruity', 'Fruity'),
    (30, 2, 'Decoy Sauvignon Blanc Sonoma County 2021', 32.50, 750, 13.9, 'Fruity', 'Herbal', 'Fruity'),
    (31, 2, 'Castello della Sala Cervaro 2022', 115.75, 750, 12.5, 'Woody', 'Fruity', 'Fruity'),
    (32, 2, 'Carte Jaune Champagne', 79.99, 750, 12, 'Fruity', 'Fruity', 'Sweet'),
    (33, 2, 'Moët & Chandon Impérial Brut Champagne', 72.99, 750, 12, 'Herbal', 'Fruity', 'Sweet'),
    (34, 2, 'Bollinger Special Cuvée Brut Aÿ Champagne', 107.99, 750, 12, 'Fruity', 'Fruity', 'Herbal'),
    (35, 2, 'Laurent-Perrier La Cuvée Brut Champagne', 87.99, 750, 12, 'Fruity', 'Sweet', 'Fruity'),
    (36, 2, 'Réserve Champagne', 89.99, 750, 12, 'Sweet', 'Fruity', 'Herbal'),
    (37, 2, 'Perrier-Jouët Grand Brut Champagne', 84.99, 750, 12, 'Fruity', 'Sweet', 'Fruity'),
    (38, 2, 'Billecart-Salmon Brut Réserve Champagne', 85.99, 750, 12, 'Fruity', 'Sweet', 'Fruity'),
    (39, 2, 'Laurent-Perrier Cuvée Rosé', 119.99, 750, 12, 'Sweet', 'Herbal', 'Sweet'),
    (40, 2, 'G.H. Mumm (Cordon Rouge) Brut Champagne', 79.99, 750, 12, 'Sweet', 'Herbal', 'Fruity'),
    (100, 3, 'Jameson 12 year Special Reserve', 41.75, 750, 40, 'Woody', 'Fruity', 'Fruity'),
    (101, 3, 'Evan Williams 1783 Small Batch Bourbon', 37.09, 750, 45, 'Fruity', 'Sweet', 'Fruity'),
    (102, 3, 'J.P. Wisers Triple Barrel Rye', 34.16, 750, 45, 'Woody', 'Fruity', 'Fruity'),
    (103, 3, 'Jim Beam Bonded Bourbon', 29.95, 750, 50, 'Fruity', 'Fruity', 'Fruity'),
    (104, 3, 'Jim Beam Pre-Prohibition Style Rye', 20.37, 750, 45, 'Fruity', 'Sweet', 'Fruity'),
    (105, 3, 'Stalk & Barrel Red Blend', 40.00, 750, 43, 'Sweet', 'Fruity', 'Fruity'),
    (106, 3, 'Russells Reserve Single Barrel Bourbon', 71.65, 750, 55, 'Fruity', 'Herbal', 'Woody'),
    (109, 3, 'Stagg Jr Barrel Proof Bourbon Batch 13', 310.47, 750, 64.2, 'Fruity', 'Herbal', 'Fruity'),
    (110, 3, 'Papas Pilar Sherry Finish Dark Rum', 50.99, 750, 43, 'Fruity', 'Fruity', 'Sweet'),
    (111, 3, 'Siesta Key Toasted Coconut', 29.99, 750, 35, 'Fruity', 'Fruity', 'Fruity'),
    (112, 3, 'Ron Abuelo 12 Años', 71.50, 750, 40, 'Sweet', 'Sweet', 'Sweet'),
    (113, 3, 'Ron Diplomático Reserva Exclusiva Rum', 63.00, 750, 40, 'Fruity', 'Herbal', 'Fruity'),
    (114, 3, 'Beach House Spiced Rum', 94.99, 750, 40, 'Fruity', 'Fruity', 'Fruity'),
    (115, 3, 'Bumbu The Original', 45.99, 750, 35, 'Fruity', 'Fruity', 'Fruity'),
    (116, 3, 'Foursquare Nobiliary', 140.00, 750, 62, 'Sweet', 'Woody', 'Sweet'),
    (117, 3, 'Appleton Estate 21 Year Limited Edition', 177.99, 750, 43, 'Sweet', 'Fruity', 'Woody'),
    (118, 3, 'Appleton Estate 15 Year Black River Casks', 80.89, 750, 43, 'Sweet', 'Sweet', 'Woody'),
    (119, 3, 'Captain Morgan Private Stock Rum', 38.25, 750, 40, 'Sweet', 'Woody', 'Sweet'),
    (300, 3, 'Tito''s Handmade Vodka', 37.99, 1750, 40, 'Fruity', 'Sweet', 'Sweet'),
    (301, 3, 'Svedka Vodka', 26.99, 1750, 40, 'Fruity', 'Sweet', 'Sweet'),
    (302, 3, 'Grey Goose Vodka', 29.99, 750, 40, 'Sweet', 'Sweet', 'Sweet'),
    (303, 3, 'Absolut Vodka', 36.99, 1750, 40, 'Sweet', 'Sweet', 'Sweet'),
    (304, 3, 'Ketel One Vodka', 41.99, 1750, 40, 'Fruity', 'Sweet', 'Sweet'),
    (305, 3, 'Smirnoff Vodka', 12.99, 750, 40, 'Fruity', 'Sweet', 'Sweet'),
    (306, 3, 'Skyy Vodka', 25.99, 1750, 40, 'Fruity', 'Sweet', 'Sweet'),
    (307, 3, 'Stolichnaya Vodka', 18.99, 750, 40, 'Fruity', 'Sweet', 'Sweet'),
    (308, 3, 'Chopin Wheat Vodka', 23.09, 750, 40, 'Fruity', 'Sweet', 'Sweet'),
    (309, 3, 'Reyka Vodka', 19.99, 750, 40, 'Fruity', 'Sweet', 'Sweet'),
    (310, 3, 'Russian Standard Vodka', 64.99, 750, 40, 'Fruity', 'Sweet', 'Sweet'),
    (311, 3, 'Cîroc Vodka', 35.10, 750, 40, 'Fruity', 'Fruity', 'Sweet'),
    (312, 3, 'Cîroc Apple', 36.50, 750, 35, 'Fruity', 'Herbal', 'Fruity'),
    (313, 3, 'Cîroc Peach', 36.50, 750, 35, 'Fruity', 'Sweet', 'Fruity'),
    (314, 3, 'Cîroc Pineapple', 36.50, 750, 35, 'Fruity', 'Sweet', 'Sweet'),
    (315, 3, 'Cîroc French Vanilla', 36.50, 750, 35, 'Fruity', 'Sweet', 'Sweet'),
    (316, 3, 'Cîroc Coconut', 38.30, 750, 35, 'Herbal', 'Sweet', 'Sweet'),
    (317, 3, 'Cîroc Mango', 36.50, 750, 35, 'Sweet', 'Herbal', 'Sweet'),
    (318, 3, 'Cîroc Black Raspberry', 38.30, 750, 35, 'Herbal', 'Sweet', 'Fruity'),
    (319, 3, 'Cîroc Summer Citrus', 38.30, 750, 35, 'Sweet', 'Herbal', 'Fruity'),
    (320, 3, 'Cîroc White Grape', 38.30, 750, 35, 'Herbal', 'Sweet', 'Fruity'),
    (321, 3, 'Cîroc Red Berry', 36.50, 750, 35, 'Herbal', 'Sweet', 'Fruity'),
    (322, 3, 'Cîroc Amaretto', 38.30, 750, 35, 'Herbal', 'Sweet', 'Fruity'),
    (323, 3, 'Cîroc Summer Watermelon', 36.50, 750, 35, 'Sweet', 'Sweet', 'Sweet'),
    (340, 3, 'Malibu Original Rum', 28.70, 750, 21, 'Fruity', 'Woody', 'Sweet'),
    (341, 3, 'Dead Man''s Fingers Spiced Rum', 32.90, 750, 37.5, 'Fruity', 'Woody', 'Sweet'),
    (342, 3, 'Dead Man''s Fingers Coffee Rum', 32.90, 750, 40, 'Sweet', 'Woody', 'Fruity'),
    (343, 3, 'Dead Man''s Fingers Coconut Rum', 32.90, 750, 40, 'Fruity', 'Fruity', 'Sweet'),
    (350, 2, 'Enrique Foster Malbec Firmado', 72.99, 750, 14.5, 'Fruity', 'Fruity', 'Sweet'),
    (351, 2, 'Harvester Cabernet Sauvignon Paso Robles', 19.99, 750, 14.5, 'Sweet', 'Fruity', 'Sweet'),
    (352, 2, 'D''Autrefois Pinot Noir', 14.99, 750, 12.5, 'Fruity', 'Sweet', 'Sweet'),
    (353, 2, 'Mascota Vineyards Unanime Cabernet', 25.99, 750, 14.5, 'Sweet', 'Fruity', 'Sweet'),
    (354, 2, 'Koskil Pinot Noir Patagonia', 16.99, 750, 13, 'Fruity', 'Fruity', 'Sweet'),
    (355, 2, 'Tenuta di Renieri Chianti Classico', 19.99, 750, 14, 'Fruity', 'Fruity', 'Sweet'),
    (356, 2, 'Chateau de Thau Cotes de Bourg', 19.99, 750, 14, 'Herbal', 'Fruity', 'Herbal'),
    (357, 2, 'San Gregorio El Vergal Tempranillo', 12.99, 750, 14.5, 'Woody', 'Sweet', 'Sweet'),
    (358, 2, 'Plea', 44.99, 750, 14, 'Fruity', 'Sweet', 'Herbal'),
    (359, 2, '1858 Merlot California', 29.99, 750, 14.9, 'Sweet', 'Fruity', 'Fruity'),
    (360, 2, 'Sangria', 15.99, 750, 11, 'Sweet', 'Fruity', 'Herbal'),
    (370, 2, 'Château Minuty Rosé Et Or', 20.00, 750, 12.5, 'Sweet', 'Fruity', 'Herbal'),
    (371, 2, 'Gérard Bertrand Gris Blanc', 12.00, 750, 12.5, 'Sweet', 'Fruity', 'Fruity'),
    (372, 2, 'Mathilde Chapoutier Grand Ferrage', 18.00, 750, 13, 'Fruity', 'Fruity', 'Herbal'),
    (373, 2, 'Château Puech-Haut Saint-Drézéry Tête De Bélier Rosé', 30.00, 750, 13.5, 'Woody', 'Fruity', 'Herbal'),
    (374, 2, 'M de Château Minuty Rosé', 15.00, 750, 13, 'Fruity', 'Sweet', 'Sweet'),
    (375, 2, 'Château Puech-Haut Saint-Drézéry Prestige Rosé', 18.00, 750, 13, 'Sweet', 'Fruity', 'Fruity'),
    (376, 2, 'Château Sainte Roseline Cuvée Lampe De Méduse', 35.00, 750, 13, 'Sweet', 'Fruity', 'Fruity'),
    (377, 2, 'Domaines Ott ''By.Ott'' Côtes de Provence Rosé', 22.00, 750, 13, 'Sweet', 'Herbal', 'Sweet'),
    (378, 2, 'Château La Tour de l''Evêque Pétale de Rosé', 40.00, 750, 14, 'Herbal', 'Sweet', 'Sweet'),
    (379, 2, 'Clos Canarelli Corse Figari Rosé', 30.00, 750, 13.5, 'Fruity', 'Fruity', 'Sweet'),
    (400, 2, 'Prosecco', 21.99, 750, 11, 'Woody', 'Woody', 'Fruity'),
    (420, 3, 'Monkey 47 Dry Gin', 65.00, 750, 47, 'Fruity', 'Herbal', 'Fruity'),
    (421, 3, 'Beefeater London Dry Gin', 18.99, 750, 47, 'Herbal', 'Herbal', 'Herbal'),
    (422, 3, 'Eden Mill Love Gin', 39.99, 750, 42, 'Fruity', 'Fruity', 'Fruity'),
    (423, 3, 'St. George Botanivore Gin', 32.99, 750, 45, 'Fruity', 'Fruity', 'Herbal'),
    (424, 3, 'Hernö Juniper Cask Gin', 93.00, 750, 47, 'Herbal', 'Herbal', 'Herbal'),
    (425, 3, 'Bulrush Gin', 32.99, 750, 44, 'Fruity', 'Herbal', 'Fruity'),
    (426, 3, 'Nolet''s Silver Gin', 34.99, 750, 47.6, 'Fruity', 'Fruity', 'Fruity'),
    (427, 3, 'Leopold''s Navy Strength American Gin', 44.00, 750, 57, 'Fruity', 'Fruity', 'Herbal'),
    (428, 3, 'Plymouth Navy Strength Gin', 49.98, 750, 57, 'Fruity', 'Herbal', 'Fruity'),
    (429, 3, 'Sipsmith VJOP London Dry Gin', 50.00, 750, 57.7, 'Herbal', 'Herbal', 'Fruity'),
    (430, 3, 'Clase Azul Tequila Reposado', 205.00, 750, 40, 'Sweet', 'Sweet', 'Sweet'),
    (431, 3, 'Don Julio 1942 Tequila', 181.00, 750, 40, 'Woody', 'Fruity', 'Sweet'),
    (432, 3, 'Casamigos Reposado Tequila', 54.00, 750, 40, 'Sweet', 'Woody', 'Sweet'),
    (433, 3, 'Patrón Silver Tequila', 51.00, 750, 40, 'Woody', 'Sweet', 'Fruity'),
    (434, 3, 'Don Julio Añejo Tequila', 53.99, 750, 40, 'Sweet', 'Woody', 'Fruity'),
    (435, 3, 'Casamigos Blanco Tequila', 49.00, 750, 40, 'Woody', 'Sweet', 'Herbal'),
    (436, 3, 'Casamigos Añejo Tequila', 61.00, 750, 40, 'Woody', 'Sweet', 'Fruity'),
    (437, 3, 'Corralejo Reposado Tequila', 33.00, 750, 40, 'Woody', 'Sweet', 'Herbal'),
    (438, 3, 'Espolòn Blanco Tequila', 29.00, 750, 40, 'Woody', 'Sweet', 'Herbal'),
    (439, 3, 'Espolòn Reposado Tequila', 32.00, 750, 40, 'Sweet', 'Fruity', 'Herbal'),
    (440, 3, 'Siempre Tequila Plata', 49.99, 750, 40, 'Fruity', 'Sweet', 'Sweet'),
    (450, 3, 'Chivas Regal 18', 149.95, 750, 40, 'Herbal', 'Fruity', 'Sweet'),
    (451, 3, 'Johnnie Walker Blue Label', 359.95, 750, 40, 'Fruity', 'Sweet', 'Fruity'),
    (452, 3, 'Jameson 12 year Special Reserve', 41.75, 750, 40, 'Woody', 'Fruity', 'Fruity'),
    (453, 3, 'Evan Williams 1783 Small Batch Bourbon', 37.09, 750, 45, 'Fruity', 'Sweet', 'Fruity'),
    (454, 3, 'J.P. Wiser''s Triple Barrel Rye', 34.16, 750, 45, 'Woody', 'Fruity', 'Fruity'),
    (455, 3, 'Jim Beam Bonded Bourbon', 29.95, 750, 50, 'Fruity', 'Fruity', 'Fruity'),
    (456, 3, 'Jim Beam Pre-Prohibition Style Rye', 20.37, 750, 45, 'Fruity', 'Sweet', 'Fruity'),
    (457, 3, 'Stalk & Barrel Red Blend', 40.00, 750, 43, 'Sweet', 'Fruity', 'Fruity'),
    (458, 3, 'Russell''s Reserve Single Barrel Bourbon', 71.65, 750, 55, 'Fruity', 'Herbal', 'Woody'),
    (459, 3, 'George Dickel 13 Year Bottled in Bond Tennessee Whisky', 51.98, 750, 50, 'Fruity', 'Sweet', 'Fruity'),
    (460, 3, 'Compass Box Spice Tree', 65.33, 750, 46, 'Fruity', 'Fruity', 'Fruity'),
    (461, 3, 'Stagg Jr Barrel Proof Bourbon Batch 13', 310.47, 750, 64.2, 'Fruity', 'Herbal', 'Fruity'),
    (462, 3, 'Wild Turkey Rare Breed Barrel Proof Bourbon', 56.90, 750, 58.4, 'Woody', 'Fruity', 'Fruity'),
    (463, 3, 'Knob Creek 18 Year Bourbon', 169.99, 750, 50, 'Fruity', 'Sweet', 'Fruity'),
    (464, 3, 'Larceny Barrel Proof Batch A124', 64.99, 750, 62.1, 'Fruity', 'Sweet', 'Sweet'),
    (465, 3, 'Booker''s Bourbon Batch 2024-01 "Springfield Batch"', 89.99, 750, 62.25, 'Fruity', 'Sweet', 'Sweet'),
    (470, 3, 'Château de Montifaud Napoléon Petite Champagne Cognac', 61.81, 750, 40, 'Rich', 'Fruity', 'Sweet'),
    (471, 3, 'Caravedo Pisco Mosto Verde', 42.85, 750, 43, 'Fruity', 'Fruity', 'Fruity'),
    (472, 3, 'St. George Pear Brandy', 44.25, 750, 40, 'Fruity', 'Sweet', 'Herbal'),
    (473, 3, 'Rémy Martin 1738 Accord Royal Cognac', 68.13, 750, 40, 'Fruity', 'Fruity', 'Sweet'),
    (474, 3, 'Pierre Ferrand Ambre Cognac', 51.98, 750, 40, 'Fruity', 'Sweet', 'Fruity'),
    (475, 3, 'Christian Drouin Sélection Calvados', 39.34, 750, 40, 'Fruity', 'Fruity', 'Fruity'),
    (476, 3, 'Martell VS Single Distillery', 40.04, 750, 40, 'Fruity', 'Sweet', 'Fruity'),
    (477, 3, 'Martell Blue Swift', 55.49, 750, 40, 'Fruity', 'Sweet', 'Fruity'),
    (478, 3, 'Copper & Kings Floodwall Apple Brandy', 39.34, 750, 50, 'Fruity', 'Sweet', 'Sweet'),
    (479, 3, 'Cardenal Mendoza Solera Gran Reserva Brandy de Jerez', 44.25, 750, 40, 'Woody', 'Herbal', 'Fruity'),
    (480, 3, 'Aperol', 32.70, 750, 11, 'Herbal', 'Sweet', 'Fruity'),
    (481, 3, 'Jagermeister', 30.35, 750, 35, 'Sweet', 'Herbal', 'Herbal'),
    (482, 3, 'Campari', 29.99, 750, 24, 'Herbal', 'Herbal', 'Fruity'),
    (483, 3, 'Fernet-Branca', 34.99, 750, 39, 'Herbal', 'Herbal', 'Herbal'),
    (484, 3, 'Chartreuse Green', 65.99, 750, 55, 'Herbal', 'Herbal', 'Sweet'),
    (485, 3, 'Chartreuse Yellow', 64.99, 750, 40, 'Herbal', 'Sweet', 'Fruity'),
    (486, 3, 'Cointreau', 39.99, 750, 40, 'Fruity', 'Sweet', 'Fruity'),
    (487, 3, 'Grand Marnier Cordon Rouge', 41.99, 750, 40, 'Fruity', 'Fruity', 'Sweet'),
    (488, 3, 'Luxardo Maraschino', 35.99, 750, 32, 'Fruity', 'Sweet', 'Fruity'),
    (489, 3, 'St-Germain Elderflower', 37.99, 750, 20, 'Fruity', 'Sweet', 'Fruity'),
    (490, 3, 'Benedictine DOM', 38.99, 750, 40, 'Herbal', 'Herbal', 'Sweet'),
    (491, 3, 'Amaro Montenegro', 34.99, 750, 23, 'Herbal', 'Herbal', 'Sweet'),
    (492, 3, 'Averna Amaro', 32.99, 750, 29, 'Herbal', 'Herbal', 'Sweet'),
    (493, 3, 'Cynar', 28.99, 750, 16.5, 'Herbal', 'Herbal', 'Fruity'),
    (494, 3, 'Ramazzotti Amaro', 31.99, 750, 30, 'Herbal', 'Sweet', 'Herbal'),
    (495, 3, 'Kahlúa', 27.99, 750, 20, 'Herbal', 'Sweet', 'Fruity'),
    (496, 3, 'Baileys Irish Cream', 29.99, 750, 17, 'Sweet', 'Sweet', 'Herbal'),
    (497, 3, 'Drambuie', 41.99, 750, 40, 'Fruity', 'Herbal', 'Sweet'),
    (498, 3, 'Chambord', 36.99, 750, 16.5, 'Fruity', 'Sweet', 'Fruity'),
    (499, 3, 'Frangelico', 32.99, 750, 20, 'Sweet', 'Sweet', 'Fruity'),
    (500, 3, 'Limoncello di Capri', 24.99, 750, 30, 'Fruity', 'Sweet', 'Fruity'),
    (501, 3, 'Galliano L''Autentico', 32.99, 750, 42.3, 'Herbal', 'Sweet', 'Sweet'),
    (502, 3, 'Ancho Reyes Original', 34.99, 750, 40, 'Herbal', 'Herbal', 'Fruity'),
    (503, 3, 'Licor 43', 29.99, 750, 31, 'Sweet', 'Sweet', 'Fruity'),
    (504, 3, 'Tia Maria', 29.99, 750, 20, 'Herbal', 'Herbal', 'Sweet'),
    (505, 3, 'Raki (Yeni Raki)', 27.99, 750, 45, 'Fruity', 'Fruity', 'Sweet'),
    (506, 3, 'Grand Marnier', 41.99, 750, 40, 'Herbal', 'Sweet', 'Sweet'),
    (507, 3, 'Ouzo', 22.99, 750, 40, 'Sweet', 'Fruity', 'Woody'),
    (900, 4, 'Heineken Non-Alcoholic 0.0', 12.95, 1980, 0.01, 'Fruity', 'Fruity', 'Woody'),
    (901, 4, 'Corona Non-Alcoholic', 11.45, 1980, 0.5, 'Herbal', 'Sweet', 'Herbal'),
    (902, 4, 'Guinness 0', 11.95, 440, 0.5, 'Sweet', 'Fruity', 'Woody'),
    (903, 4, 'Clausthaler Premium Non Alcoholic', 2.20, 500, 0.01, 'Sweet', 'Fruity', 'Sweet'),
    (904, 4, 'Partake Brewing Non-Alcoholic IPA', 2.00, 355, 0.3, 'Woody', 'Fruity', 'Woody'),
    (905, 4, 'Partake Brewing Non-Alcoholic Pale Ale', 2.00, 355, 0.3, 'Woody', 'Herbal', 'Sweet'),
    (906, 4, 'Athletic Brewing Run Wild Non-Alcoholic IPA', 13.95, 355, 0.5, 'Woody', 'Fruity', 'Woody'),
    (907, 4, 'Nozeco Sparkling Dealcoholized', 12.95, 750, 0.01, 'Woody', 'Fruity', 'Sweet'),
    (908, 4, 'Luna De Murviedro Dealcoholized Sparkling Rose', 9.95, 750, 0.01, 'Fruity', 'Fruity', 'Fruity'),
    (909, 4, 'Nozeco Sparkling Rose Dealcoholized', 11.45, 750, 0.5, 'Sweet', 'Fruity', 'Woody'),
    (910, 4, 'Henkell Dealcoholized Sparkling Wine', 11.95, 750, 0.01, 'Woody', 'Fruity', 'Sweet'),
    (911, 4, 'Tarapacá Dealcoholized Sauvignon Blanc', 10.95, 750, 0.5, 'Fruity', 'Fruity', 'Sweet'),
    (912, 4, 'Ritual Zero Proof Whiskey Alternative', 42.00, 750, 0.0, 'Herbal', 'Fruity', 'Fruity'),
    (913, 4, 'Seedlip Garden 108', 51.00, 750, 0.5, 'Sweet', 'Woody', 'Herbal'),
    (914, 4, 'Lyres American Malt', 44.00, 750, 0.5, 'Herbal', 'Herbal', 'Fruity'),
    (915, 4, 'Gruvi Dry Secco', 14.99, 750, 0.5, 'Fruity', 'Sweet', 'Fruity'),
    (916, 4, 'Fre Alcohol-Removed Chardonnay', 9.99, 750, 0.5, 'Fruity', 'Fruity', 'Sweet'),
    (917, 4, 'Ariel Cabernet Sauvignon', 12.99, 750, 0.5, 'Fruity', 'Fruity', 'Fruity'),
    (918, 4, 'Leitz Eins Zwei Zero Riesling', 18.50, 750, 0.0, 'Fruity', 'Fruity', 'Sweet'),
    (919, 4, 'Pierre Zéro Merlot', 15.99, 750, 0.0, 'Herbal', 'Fruity', 'Fruity'),
    (920, 4, 'Surely Non-Alcoholic Sparkling Rosé', 24.99, 750, 0.5, 'Fruity', 'Fruity', 'Fruity'),
    (921, 4, 'St. Regis Chardonnay', 11.99, 750, 0.5, 'Fruity', 'Woody', 'Fruity'),
    (922, 4, 'Töst Sparkling White Tea', 8.99, 750, 0.0, 'Herbal', 'Fruity', 'Fruity'),
    (923, 4, 'Thomson & Scott Noughty Rosé', 20.99, 750, 0.5, 'Fruity', 'Fruity', 'Fruity'),
    (924, 4, 'Grüvi Bubbly Rosé', 14.99, 750, 0.5, 'Fruity', 'Fruity', 'Fruity'),
    (925, 4, 'Athletic Brewing Upside Dawn Golden Ale', 12.99, 355, 0.5, 'Herbal', 'Woody', 'Fruity'),
    (926, 4, 'Clausthaler Dry-Hopped Non-Alcoholic', 2.50, 500, 0.5, 'Herbal', 'Herbal', 'Woody'),
    (927, 4, 'BrewDog Nanny State', 11.99, 330, 0.5, 'Woody', 'Sweet', 'Herbal'),
    (928, 4, 'Bravus Oatmeal Dark', 13.99, 355, 0.5, 'Herbal', 'Fruity', 'Woody'),
    (929, 4, 'Lagunitas IPNA', 10.99, 355, 0.5, 'Fruity', 'Woody', 'Sweet'),
    (930, 4, 'WellBeing Victory Wheat', 10.99, 355, 0.5, 'Woody', 'Fruity', 'Sweet'),
    (931, 4, 'Erdinger Weissbier Alkoholfrei', 3.50, 500, 0.5, 'Woody', 'Woody', 'Fruity'),
    (932, 4, 'Suntory All-Free', 12.99, 350, 0.0, 'Herbal', 'Sweet', 'Sweet'),
    (933, 4, 'Seedlip Spice 94', 37.99, 750, 0.0, 'Herbal', 'Fruity', 'Fruity'),
    (934, 4, 'Ritual Zero Proof Gin Alternative', 26.99, 750, 0.0, 'Herbal', 'Herbal', 'Fruity'),
    (935, 4, 'Monday Zero Alcohol Gin', 39.99, 750, 0.0, 'Sweet', 'Herbal', 'Sweet'),
    (936, 4, 'Lyre"s Dry London Spirit', 35.00, 700, 0.0, 'Herbal', 'Herbal', 'Sweet'),
    (937, 4, 'Free Spirits Non-Alcoholic Bourbon', 35.00, 750, 0.0, 'Herbal', 'Sweet', 'Woody'),
    (938, 4, 'Arkay Alcohol-Free Whisky', 27.50, 750, 0.0, 'Fruity', 'Fruity', 'Sweet'),
    (939, 4, 'Fluère Spiced Cane Dark Roast', 30.00, 700, 0.0, 'Fruity', 'Sweet', 'Sweet'),
    (940, 4, 'Erdinger Weissbier Alkoholfrei', 14.19, 500, 0.5, 'Herbal', 'Sweet', 'Fruity'),
    (941, 4, 'Estrella Galicia 0.0', 13.24, 500, 0.5, 'Herbal', 'Woody', 'Fruity'),
    (942, 4, 'Flat Tire Non-Alcoholic', 11.99, 500, 0.5, 'Herbal', 'Fruity', 'Sweet'),
    (943, 4, 'Giesen 0% Sauvignon Blanc', 11.22, 330, 0.0, 'Fruity', 'Fruity', 'Woody'),
    (944, 4, 'Leitz Eins Zwei Zero Riesling', 10.79, 750, 0.0, 'Fruity', 'Woody', 'Sweet'),
    (945, 4, 'Noughty Alcohol-Free Sparkling Chardonnay', 10.82, 750, 0.0, 'Fruity', 'Herbal', 'Fruity'),
    (946, 4, 'Seedlip Garden 108', 14.57, 330, 0.0, 'Herbal', 'Woody', 'Herbal'),
    (947, 4, 'Ritual Zero Proof Gin Alternative', 15.80, 330, 0.0, 'Herbal', 'Fruity', 'Sweet'),
    (948, 4, 'Lyre''s Dry London Spirit', 14.18, 750, 0.0, 'Herbal', 'Herbal', 'Fruity'),
    (949, 4, 'Monday Zero Alcohol Gin', 14.63, 500, 0.0, 'Herbal', 'Fruity', 'Woody'),
    (950, 4, 'Free Spirits Non-Alcoholic Bourbon', 15.23, 330, 0.0, 'Woody', 'Herbal', 'Sweet'),
    (951, 4, 'Ariel Cabernet Sauvignon', 12.12, 750, 0.0, 'Fruity', 'Herbal', 'Sweet'),
    (952, 4, 'Fre Alcohol-Removed Chardonnay', 9.65, 355, 0.0, 'Fruity', 'Sweet', 'Woody'),
    (953, 4, 'Athletic Brewing Upside Dawn Golden Ale', 10.48, 355, 0.5, 'Herbal', 'Sweet', 'Fruity'),
    (954, 4, 'BrewDog Nanny State', 12.54, 355, 0.5, 'Herbal', 'Fruity', 'Sweet');
        
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
(939, FALSE, 'Spirits'),
(940, TRUE, 'Beer'),
(941, TRUE, 'Beer'),
(942, TRUE, 'Beer'),
(943, FALSE, 'Wine'),
(944, FALSE, 'Wine'),
(945, TRUE, 'Wine'),
(946, FALSE, 'Spirits'),
(947, FALSE, 'Spirits'),
(948, FALSE, 'Spirits'),
(949, FALSE, 'Spirits'),
(950, FALSE, 'Spirits'),
(951, FALSE, 'Wine'),
(952, FALSE, 'Wine'),
(953, TRUE, 'Beer'),
(954, TRUE, 'Beer');

-- Beer Data Input --
INSERT INTO beer(id, beerType, beerOrigin) VALUES
-- LAGERS
(600, 'Lagers', 'Mexico City, Mexico'),
(601, 'Lagers', 'Amsterdam, Netherlands'),
(602, 'Lagers', 'St. Louis, USA'),
(603, 'Lagers', 'Golden, USA'),
(604, 'Lagers', 'Milwaukee, USA'),
(605, 'Lagers', 'Tokyo, Japan'),
(606, 'Lagers', 'Copenhagen, Denmark'),
(607, 'Lagers', 'Bremen, Germany'),
(608, 'Lagers', 'Strasbourg, France'),

-- STOUTS
(609, 'Stouts', 'Dublin, Ireland'),
(610, 'Stouts', 'Chico, California, USA'),
(611, 'Stouts', 'Cork, Ireland'),
(612, 'Stouts', 'Tadcaster, UK'),
(613, 'Stouts', 'Longmont, Colorado, USA'),
(614, 'Stouts', 'Jamaica'),
(615, 'Stouts', 'Michigan, USA'),
(616, 'Stouts', 'London, UK'),

-- PILSNERS
(617, 'Pilsners', 'Pilsen, Czech Republic'),
(618, 'Pilsners', 'Czech Republic'),
(619, 'Pilsners', 'Bitburg, Germany'),
(620, 'Pilsners', 'Warstein, Germany'),
(621, 'Pilsners', 'Jever, Germany'),
(622, 'Pilsners', 'Krombach, Germany'),
(623, 'Pilsners', 'Munich, Germany'),
(624, 'Pilsners', 'Belgium'),

-- ALES
(625, 'Ales', 'Portland, Oregon, USA'),
(626, 'Ales', 'San Diego, California, USA'),
(627, 'Ales', 'Petaluma, California, USA'),
(628, 'Ales', 'Newcastle, UK'),
(629, 'Ales', 'Fort Collins, Colorado, USA'),
(630, 'Ales', 'Brussels, Belgium'),
(631, 'Ales', 'Leuven, Belgium');

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
(470,2),
(471,2),
(472,2),
(473,2),
(474,2),
(475,2),
(476,2),
(477,2),
(478,2),
(479,2),
(300,6),
(301,6),
(302,6),
(303,6),
(304,6),
(305,6),
(306,6),
(307,6),
(308,6),
(309,6),
(310,6),
(311,6),
(312,6),
(313,6),
(314,6),
(315,6),
(316,6),
(317,6),
(318,6),
(319,6),
(320,6),
(321,6),
(322,6),
(323,6),
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
(430, 4),  -- Clase Azul Tequila Reposado
(431, 4),  -- Don Julio 1942 Tequila
(432, 4),  -- Casamigos Reposado Tequila
(433, 4),  -- Patrón Silver Tequila
(434, 4),  -- Don Julio Añejo Tequila
(435, 4),  -- Casamigos Blanco Tequila
(436, 4),  -- Casamigos Añejo Tequila
(437, 4),  -- Corralejo Reposado Tequila
(438, 4),  -- Espolòn Blanco Tequila
(439, 4),  -- Espolòn Reposado Tequila
(440, 4),  -- Siempre Tequila Plata
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

-- Vodka Data Input --
INSERT INTO vodka(id, country_origin) VALUES
    (300, 'USA'),
    (301, 'Sweden'),
    (302, 'France'),
    (303, 'Sweden'),
    (304, 'Holland'),
    (305, 'USA'),
    (306, 'USA'),
    (307, 'Latvia'),
    (308, 'Poland'),
    (309, 'Iceland'),
    (310, 'St. Petersburg, Russia'),
    (311, 'France'),
    (312, 'France'),
    (313, 'France'),
    (314, 'France'),
    (315, 'France'),
    (316, 'France'),
    (317, 'France'),
    (318, 'France'),
    (319, 'France'),
    (320, 'France'),
    (321, 'France'),
    (322, 'France'),
    (323, 'France');


-- Brandy Data Input --
INSERT INTO brandy (id, barrelType)
VALUES
    (470, 'French Oak (Limousin, Tronçais)'),
    (471, 'Unaged (Stainless Steel or Glass)'),
    (472, 'Unaged (Stainless Steel)'),
    (473, 'French Oak (Limousin)'),
    (474, 'French Oak (Limousin, Tronçais)'),
    (475, 'French Oak'),
    (476, 'French Oak (Tronçais)'),
    (477, 'Finished in Kentucky Bourbon Casks'),
    (478, 'American Oak'),
    (479, 'American Oak (Sherry Solera System)');

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

-- Tequila Data Input --
INSERT INTO tequila(id, type) VALUES
(430, 'Reposado'),  -- Clase Azul Tequila Reposado
(431, 'Anejo'),     -- Don Julio 1942 Tequila
(432, 'Reposado'),  -- Casamigos Reposado Tequila
(433, 'Blanco'),    -- Patrón Silver Tequila
(434, 'Anejo'),     -- Don Julio Añejo Tequila
(435, 'Blanco'),    -- Casamigos Blanco Tequila
(436, 'Anejo'),     -- Casamigos Añejo Tequila
(437, 'Reposado'),  -- Corralejo Reposado Tequila
(438, 'Blanco'),    -- Espolòn Blanco Tequila
(439, 'Reposado'),  -- Espolòn Reposado Tequila
(440, 'Blanco');    -- End of list



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

INSERT INTO pairing_table (id, category_id, food_id, recommend_rank, match_flavour)
VALUES

    -- ( Meat , White wine )

    -- ( Fish , Beer & )

    -- 1) Steak (Ribeye) -> Red Wine (2), Whisky (3)
    (10001, 2, 1001, 1, 'Rich, Spicy'),
    (10002, 3, 1001, 2, 'Rich, Full'),

    -- 2) Filet Mignon -> Red Wine (2), Brandy (3)
    (10003, 2, 1002, 1, 'Fruity, Earthy'),
    (10004, 3, 1002, 2, 'Rich, Fruity'),

    -- 3) Grilled Salmon -> White Wine (2), Rosé (2)
    (10005, 2, 1003, 1, 'Fruity, Earthy'),
    (10006, 2, 1003, 2, 'Fruity, Floral'),

    -- 4) Spaghetti Carbonara -> White Wine (2), Sparkling Wine (2)
    (10007, 2, 1004, 1, 'Rich, Creamy'),
    (10008, 2, 1004, 2, 'Crisp, Citrus'),

    -- 5) Sushi -> Sake (3), White Wine (2)
    (10009, 3, 1005, 1, 'Fruity, Floral'),
    (10010, 2, 1005, 2, 'Floral, Sweet'),

    -- 6) BBQ Ribs -> Red Wine (2), Bourbon (3)
    (10011, 2, 1006, 1, 'Spicy, Rich'),
    (10012, 3, 1006, 2, 'Sweet, Spicy'),

    -- 7) Cheese Platter (Soft & Aged) -> Sparkling Wine (2), Brandy (3)
    (10013, 2, 1007, 1, 'Fruity, Ageing'),
    (10014, 3, 1007, 2, 'Rich, Fruity'),

    -- 8) Mushroom Risotto -> White Wine (2), Amaro (3)
    (10015, 2, 1008, 1, 'Earthy, Floral'),
    (10016, 3, 1008, 2, 'Herbal, Bitter'),

    -- 9) Spicy Thai Curry -> Riesling (2), Beer (1)
    (10017, 2, 1009, 1, 'Fruity, Sweet'),
    (10018, 1, 1009, 2, 'Fruity, Crisp'),

    -- 10) Roasted Chicken -> White Wine (2), White Wine (2)
    (10019, 2, 1010, 1, 'Woody, Earthy'),
    (10020, 2, 1010, 2, 'Fruity, Floral'),

    -- 11) Lobster with Butter Sauce -> Sparkling Wine (2), Champagne (2)
    (10021, 2, 1011, 1, 'Crisp, Citrus'),
    (10022, 2, 1011, 2, 'Fruity, Citrus'),

    -- 12) Beef Tacos -> Tequila (3), Beer (1)
    (10023, 3, 1012, 1, 'Spicy, Herbal'),
    (10024, 1, 1012, 2, 'Fruity, Malt'),

    -- 13) Vegetarian Mezze Platter -> Rosé (2), Gin (3)
    (10025, 2, 1013, 1, 'Fruity, Floral'),
    (10026, 3, 1013, 2, 'Herbal, Citrus'),

    -- 14) Lamb Shank -> Red Wine (2), Brandy (3)
    (10027, 2, 1014, 1, 'Rich, Spicy'),
    (10028, 3, 1014, 2, 'Woody, Spicy'),

    -- 15) Margherita Pizza -> Red Wine (2), Beer (1)
    (10029, 2, 1015, 1, 'Fruity, Earthy'),
    (10030, 1, 1015, 2, 'Malt, Floral'),

    -- 16) Oysters -> Champagne (2), Vodka (3)
    (10031, 2, 1016, 1, 'Citrus, Tree Fruit'),
    (10032, 3, 1016, 2, 'Neutral, Crisp'),

    -- 17) Dark Chocolate Cake -> Brandy (3), Port Wine (2)
    (10033, 3, 1017, 1, 'Rich, Sweet'),
    (10034, 2, 1017, 2, 'Sweet, Fruity'),

    -- 18) Pad Thai -> White Wine (2), Sake (3)
    (10035, 2, 1018, 1, 'Fruity, Sweet'),
    (10036, 3, 1018, 2, 'Fruity, Sweet'),

    -- 19) Duck à l’Orange -> Red Wine (2), Grand Marnier (3)
    (10037, 2, 1019, 1, 'Fruity, Tart'),
    (10038, 3, 1019, 2, 'Citrus, Sweet'),

    -- 20) Grilled Vegetables -> Rosé (2), White Wine (2)
    (10039, 2, 1020, 1, 'Fruity, Earthy'),
    (10040, 2, 1020, 2, 'Fruity, Earthy'),

    -- 21) Charcuterie Board -> Red Wine (2), Whisky (3)
    (10041, 2, 1021, 1, 'Rich, Earthy'),
    (10042, 3, 1021, 2, 'Spicy, Rich'),

    -- 22) Grilled Shrimp -> White Wine (2), Sparkling Wine (2)
    (10043, 2, 1022, 1, 'Citrus, Fruity'),
    (10044, 2, 1022, 2, 'Crisp, Citrus'),

    -- 23) Cheesecake -> Limoncello (3), Moscato (2)
    (10045, 3, 1023, 1, 'Citrus, Sweet'),
    (10046, 2, 1023, 2, 'Fruity, Sweet'),

    -- 24) Roast Duck -> Red Wine (2), Whisky (3)
    (10047, 2, 1024, 1, 'Fruity, Earthy'),
    (10048, 3, 1024, 2, 'Rich, Spicy'),

    -- 25) Indian Butter Chicken -> White Wine (2), Beer (1)
    (10049, 2, 1025, 1, 'Fruity, Sweet'),
    (10050, 1, 1025, 2, 'Malt, Spicy'),

    -- 26) Falafel -> Rosé (2), Gin (3)
    (10051, 2, 1026, 1, 'Fruity, Floral'),
    (10052, 3, 1026, 2, 'Herbal, Citrus'),

    -- 27) Beef Stroganoff -> Red Wine (2), Brandy (3)
    (10053, 2, 1027, 1, 'Rich, Creamy'),
    (10054, 3, 1027, 2, 'Rich, Sweet'),

    -- 28) Fried Calamari -> Sparkling Wine (2), White Wine (2)
    (10055, 2, 1028, 1, 'Crisp, Citrus'),
    (10056, 2, 1028, 2, 'Fruity, Earthy'),

    -- 29) Beef Burger -> Beer (1), Whisky (3)
    (10057, 1, 1029, 1, 'Malt, Bitter'),
    (10058, 3, 1029, 2, 'Spicy, Rich'),

    -- 30) Caesar Salad -> White Wine (2), Sparkling Wine (2)
    (10059, 2, 1030, 1, 'Fruity, Crisp'),
    (10060, 2, 1030, 2, 'Floral, Crisp'),

    -- 31) Tiramisu -> Coffee Liqueur (3), Brandy (3)
    (10061, 3, 1031, 1, 'Rich, Sweet'),
    (10062, 3, 1031, 2, 'Sweet, Rich'),

    -- 32) Prosciutto & Melon -> Rosé (2), Prosecco (2)
    (10063, 2, 1032, 1, 'Fruity, Sweet'),
    (10064, 2, 1032, 2, 'Fruity, Floral'),

    -- 33) Beef Wellington -> Red Wine (2), Brandy (3)
    (10065, 2, 1033, 1, 'Rich, Earthy'),
    (10066, 3, 1033, 2, 'Fruity, Spicy'),

    -- 34) Eggplant Parmesan -> Red Wine (2), Sparkling Wine (2)
    (10067, 2, 1034, 1, 'Fruity, Earthy'),
    (10068, 2, 1034, 2, 'Crisp, Floral'),

    -- 35) Biryani (Chicken) -> Riesling (2), Beer (1)
    (10069, 2, 1035, 1, 'Fruity, Sweet'),
    (10070, 1, 1035, 2, 'Fruity, Spicy'),

    -- 36) Tuna Tartare -> White Wine (2), Sake (3)
    (10071, 2, 1036, 1, 'Fruity, Citrus'),
    (10072, 3, 1036, 2, 'Fruity, Floral'),

    -- 37) Paella (Seafood) -> White Wine (2), Sangria (2)
    (10073, 2, 1037, 1, 'Fruity, Earthy'),
    (10074, 2, 1037, 2, 'Fruity, Sweet'),

    -- 38) Shakshuka -> Rosé (2), White Wine (2)
    (10075, 2, 1038, 1, 'Fruity, Spicy'),
    (10076, 2, 1038, 2, 'Fruity, Earthy'),

    -- 39) Cheeseburger -> Beer (1), Bourbon (3)
    (10077, 1, 1039, 1, 'Malt, Sweet'),
    (10078, 3, 1039, 2, 'Sweet, Spicy'),

    -- 40) Brisket -> Red Wine (2), Whisky (3)
    (10079, 2, 1040, 1, 'Rich, Earthy'),
    (10080, 3, 1040, 2, 'Rich, Spicy'),

    -- 41) Caprese Salad -> White Wine (2), Rosé (2)
    (10081, 2, 1041, 1, 'Fruity, Floral'),
    (10082, 2, 1041, 2, 'Fruity, Floral'),

    -- 42) Grilled Portobello Mushroom -> Red Wine (2), Amaro (3)
    (10083, 2, 1042, 1, 'Earthy, Fruity'),
    (10084, 3, 1042, 2, 'Herbal, Bitter'),

    -- 43) Korean Fried Chicken -> Beer (1), Soju (3)
    (10085, 1, 1043, 1, 'Malt, Crisp'),
    (10086, 3, 1043, 2, 'Neutral, Sweet'),

    -- 44) Ceviche -> White Wine (2), Pisco (3)
    (10087, 2, 1044, 1, 'Citrus, Fruity'),
    (10088, 3, 1044, 2, 'Fruity, Earthy'),

    -- 45) Pork Schnitzel -> Beer (1), White Wine (2)
    (10089, 1, 1045, 1, 'Malt, Floral'),
    (10090, 2, 1045, 2, 'Fruity, Sweet'),

    -- 46) French Onion Soup -> Red Wine (2), Sherry (2)
    (10091, 2, 1046, 1, 'Rich, Earthy'),
    (10092, 2, 1046, 2, 'Woody, Sweet'),

    -- 47) Chocolate Lava Cake -> Port (2), Brandy (3)
    (10093, 2, 1047, 1, 'Sweet, Rich'),
    (10094, 3, 1047, 2, 'Sweet, Rich'),

    -- 48) Spicy Ramen -> Sake (3), Beer (1)
    (10095, 3, 1048, 1, 'Fruity, Sweet'),
    (10096, 1, 1048, 2, 'Crisp, Malt'),

    -- 49) Chicken Souvlaki -> White Wine (2), Ouzo (3)
    (10097, 2, 1049, 1, 'Citrus, Herbal'),
    (10098, 3, 1049, 2, 'Herbal, Sweet'),

    -- 50) Stuffed Bell Peppers -> Red Wine (2), Rosé (2)
    (10099, 2, 1050, 1, 'Fruity, Earthy'),
    (10100, 2, 1050, 2, 'Fruity, Sweet'),

    -- 51) Mango Sticky Rice -> Riesling (2), Moscato (2)
    (10101, 2, 1051, 1, 'Fruity, Sweet'),
    (10102, 2, 1051, 2, 'Fruity, Sweet');


