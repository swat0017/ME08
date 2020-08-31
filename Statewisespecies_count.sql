CREATE TABLE Statewisespecies_count (
    State varchar(20),
	CriticallyEndangered int,
    Vulnerable int,
    Endangered int,
    ListedMigrationonly int,
    Total int
);

INSERT INTO Statewisespecies_count (State,Vulnerable, CriticallyEndangered, Endangered, ListedMigrationonly, Total)
VALUES ('Tas', '3', '1', '0', '0','4');

INSERT INTO Statewisespecies_count (State,Vulnerable, CriticallyEndangered, Endangered, ListedMigrationonly, Total)
VALUES ('ACT', '6', '3', '4', '0','13');

INSERT INTO Statewisespecies_count (State,Vulnerable, CriticallyEndangered, Endangered, ListedMigrationonly, Total)
VALUES ('NSW', '20', '5', '18', '0','43');

INSERT INTO Statewisespecies_count (State,Vulnerable, CriticallyEndangered, Endangered, ListedMigrationonly, Total)
VALUES ('Qld', '12', '4', '8', '0','24');

INSERT INTO Statewisespecies_count (State,Vulnerable, CriticallyEndangered, Endangered, ListedMigrationonly, Total)
VALUES ('SA', '4', '3', '6', '0','13');

INSERT INTO Statewisespecies_count (State,Vulnerable, CriticallyEndangered, Endangered, ListedMigrationonly, Total)
VALUES ('Vic', '12', '2', '11', '0','25');

INSERT INTO Statewisespecies_count (State,Vulnerable, CriticallyEndangered, Endangered, ListedMigrationonly, Total)
VALUES ('WA', '1', '1', '1', '0','3');

