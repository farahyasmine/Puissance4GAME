-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost:8889
-- Generation Time: Mar 24, 2024 at 01:31 PM
-- Server version: 5.7.39
-- PHP Version: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `puissance4`
--

-- --------------------------------------------------------

--
-- Table structure for table `blocages`
--

CREATE TABLE `blocages` (
  `blocage_id` int(11) NOT NULL,
  `partie_id` int(11) DEFAULT NULL,
  `joueur_id` int(11) DEFAULT NULL,
  `colonne` int(11) NOT NULL,
  `tour_debut` int(11) NOT NULL,
  `tour_fin` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `joueurs`
--

CREATE TABLE `joueurs` (
  `joueur_id` int(11) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `estIA` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `mouvements`
--

CREATE TABLE `mouvements` (
  `mouvement_id` int(11) NOT NULL,
  `partie_id` int(11) DEFAULT NULL,
  `joueur_id` int(11) DEFAULT NULL,
  `colonne` int(11) NOT NULL,
  `tour` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `parties`
--

CREATE TABLE `parties` (
  `partie_id` int(11) NOT NULL,
  `joueur1_id` int(11) DEFAULT NULL,
  `joueur2_id` int(11) DEFAULT NULL,
  `gagnant_id` int(11) DEFAULT NULL,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `blocages`
--
ALTER TABLE `blocages`
  ADD PRIMARY KEY (`blocage_id`),
  ADD KEY `partie_id` (`partie_id`),
  ADD KEY `joueur_id` (`joueur_id`);

--
-- Indexes for table `joueurs`
--
ALTER TABLE `joueurs`
  ADD PRIMARY KEY (`joueur_id`);

--
-- Indexes for table `mouvements`
--
ALTER TABLE `mouvements`
  ADD PRIMARY KEY (`mouvement_id`),
  ADD KEY `partie_id` (`partie_id`),
  ADD KEY `joueur_id` (`joueur_id`);

--
-- Indexes for table `parties`
--
ALTER TABLE `parties`
  ADD PRIMARY KEY (`partie_id`),
  ADD KEY `joueur1_id` (`joueur1_id`),
  ADD KEY `joueur2_id` (`joueur2_id`),
  ADD KEY `gagnant_id` (`gagnant_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `blocages`
--
ALTER TABLE `blocages`
  MODIFY `blocage_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `joueurs`
--
ALTER TABLE `joueurs`
  MODIFY `joueur_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `mouvements`
--
ALTER TABLE `mouvements`
  MODIFY `mouvement_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `parties`
--
ALTER TABLE `parties`
  MODIFY `partie_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `blocages`
--
ALTER TABLE `blocages`
  ADD CONSTRAINT `blocages_ibfk_1` FOREIGN KEY (`partie_id`) REFERENCES `parties` (`partie_id`),
  ADD CONSTRAINT `blocages_ibfk_2` FOREIGN KEY (`joueur_id`) REFERENCES `joueurs` (`joueur_id`);

--
-- Constraints for table `mouvements`
--
ALTER TABLE `mouvements`
  ADD CONSTRAINT `mouvements_ibfk_1` FOREIGN KEY (`partie_id`) REFERENCES `parties` (`partie_id`),
  ADD CONSTRAINT `mouvements_ibfk_2` FOREIGN KEY (`joueur_id`) REFERENCES `joueurs` (`joueur_id`);

--
-- Constraints for table `parties`
--
ALTER TABLE `parties`
  ADD CONSTRAINT `parties_ibfk_1` FOREIGN KEY (`joueur1_id`) REFERENCES `joueurs` (`joueur_id`),
  ADD CONSTRAINT `parties_ibfk_2` FOREIGN KEY (`joueur2_id`) REFERENCES `joueurs` (`joueur_id`),
  ADD CONSTRAINT `parties_ibfk_3` FOREIGN KEY (`gagnant_id`) REFERENCES `joueurs` (`joueur_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
