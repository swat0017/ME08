CREATE TABLE Animalcategory_count (
    AnimalCategory varchar(20),
	CrticallyEndangered int,
    Vulnerable int,
    Endangered int,
    ListedMigrationonly int 
);

ALTER TABLE Animalcategory_count
RENAME COLUMN CrticallyEndangered TO CriticallyEndangered;

INSERT INTO Animalcategory_count (AnimalCategory, CriticallyEndangered, Vulnerable, Endangered, ListedMigrationonly)
VALUES ('Mammal', '0', '8', '8', '0');

INSERT INTO Animalcategory_count (AnimalCategory, CriticallyEndangered, Vulnerable, Endangered, ListedMigrationonly)
VALUES ('Bird', '3', '2', '4', '4');

INSERT INTO Animalcategory_count (AnimalCategory, CriticallyEndangered, Vulnerable, Endangered, ListedMigrationonly)
VALUES ('Fish', '0', '1', '3', '0');

INSERT INTO Animalcategory_count (AnimalCategory, CriticallyEndangered, Vulnerable, Endangered, ListedMigrationonly)
VALUES ('Frog', '3', '7', '4', '0');

INSERT INTO Animalcategory_count (AnimalCategory, CriticallyEndangered, Vulnerable, Endangered, ListedMigrationonly)
VALUES ('Insect', '1', '1', '2', '0');

INSERT INTO Animalcategory_count (AnimalCategory, CriticallyEndangered, Vulnerable, Endangered, ListedMigrationonly)
VALUES ('Reptile', '2', '3', '2', '0');

INSERT INTO Animalcategory_count (AnimalCategory, CriticallyEndangered, Vulnerable, Endangered, ListedMigrationonly)
VALUES ('Spider', '0', '1', '0', '0');

INSERT INTO Animalcategory_count (AnimalCategory, CriticallyEndangered, Vulnerable, Endangered, ListedMigrationonly)
VALUES ('Total', '9', '23', '23', '4');
