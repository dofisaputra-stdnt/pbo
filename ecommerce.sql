-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 24, 2024 at 03:13 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ecommerce`
--

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `ID` int(10) UNSIGNED ZEROFILL NOT NULL,
  `SalesRepEmployeeNum` int(10) UNSIGNED ZEROFILL DEFAULT NULL,
  `LastName` varchar(255) DEFAULT NULL,
  `FirstName` varchar(255) DEFAULT NULL,
  `Phone` varchar(255) DEFAULT NULL,
  `Address1` varchar(255) DEFAULT NULL,
  `Address2` varchar(255) DEFAULT NULL,
  `State` varchar(255) DEFAULT NULL,
  `PostalCode` int(11) DEFAULT NULL,
  `Country` varchar(255) DEFAULT NULL,
  `CreditLimit` decimal(19,0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`ID`, `SalesRepEmployeeNum`, `LastName`, `FirstName`, `Phone`, `Address1`, `Address2`, `State`, `PostalCode`, `Country`, `CreditLimit`) VALUES
(0000000001, 0000000002, 'Johnson', 'Emily', '555-123-4567', '789 Maple St', NULL, 'CA', 90210, 'USA', 10000),
(0000000002, 0000000003, 'Williams', 'Chris', '555-987-6543', '321 Oak St', NULL, 'TX', 75001, 'USA', 15000);

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `ID` int(10) UNSIGNED ZEROFILL NOT NULL,
  `OfficeCode` int(10) UNSIGNED ZEROFILL DEFAULT NULL,
  `ReportsTo` int(10) UNSIGNED ZEROFILL DEFAULT NULL,
  `LastName` varchar(255) DEFAULT NULL,
  `FirstName` varchar(255) DEFAULT NULL,
  `Extension` varchar(255) DEFAULT NULL,
  `Email` varchar(255) DEFAULT NULL,
  `JobTitle` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`ID`, `OfficeCode`, `ReportsTo`, `LastName`, `FirstName`, `Extension`, `Email`, `JobTitle`) VALUES
(0000000001, 0000000001, NULL, 'Smith', 'John', 'x101', 'john.smith@company.com', 'CEO'),
(0000000002, 0000000001, 0000000001, 'Doe', 'Jane', 'x102', 'jane.doe@company.com', 'Sales Manager'),
(0000000003, 0000000002, 0000000001, 'Brown', 'Charlie', 'x201', 'charlie.brown@company.com', 'Marketing Manager');

-- --------------------------------------------------------

--
-- Table structure for table `office`
--

CREATE TABLE `office` (
  `Code` int(10) UNSIGNED ZEROFILL NOT NULL,
  `City` varchar(255) DEFAULT NULL,
  `Phone` varchar(255) DEFAULT NULL,
  `Address1` varchar(255) DEFAULT NULL,
  `Address2` varchar(255) DEFAULT NULL,
  `State` varchar(255) DEFAULT NULL,
  `PostalCode` int(11) DEFAULT NULL,
  `Country` varchar(255) DEFAULT NULL,
  `Territory` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `office`
--

INSERT INTO `office` (`Code`, `City`, `Phone`, `Address1`, `Address2`, `State`, `PostalCode`, `Country`, `Territory`) VALUES
(0000000001, 'New York', '123-456-7890', '123 5th Ave', NULL, 'NY', 10001, 'USA', 'East Coast'),
(0000000002, 'Los Angeles', '987-654-3210', '456 Sunset Blvd', NULL, 'CA', 90001, 'USA', 'West Coast');

-- --------------------------------------------------------

--
-- Table structure for table `order`
--

CREATE TABLE `order` (
  `ID` int(10) UNSIGNED ZEROFILL NOT NULL,
  `CustomerID` int(10) UNSIGNED ZEROFILL DEFAULT NULL,
  `OrderDate` datetime DEFAULT NULL,
  `RequiredDate` datetime DEFAULT NULL,
  `ShippedDate` datetime DEFAULT NULL,
  `Status` varchar(255) DEFAULT NULL,
  `Comments` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `order`
--

INSERT INTO `order` (`ID`, `CustomerID`, `OrderDate`, `RequiredDate`, `ShippedDate`, `Status`, `Comments`) VALUES
(0000000001, 0000000001, '2024-11-01 00:00:00', '2024-11-10 00:00:00', '2024-11-05 00:00:00', 'Shipped', 'Delivered on time'),
(0000000002, 0000000002, '2024-11-15 00:00:00', '2024-11-20 00:00:00', NULL, 'Pending', 'Urgent delivery requested'),
(0000000004, 0000000001, '2024-11-24 20:56:00', '2024-11-24 20:56:00', '2024-11-24 20:56:00', 'sdf', 'sdf');

-- --------------------------------------------------------

--
-- Table structure for table `order_product`
--

CREATE TABLE `order_product` (
  `ID` int(10) UNSIGNED ZEROFILL NOT NULL,
  `OrderID` int(10) UNSIGNED ZEROFILL DEFAULT NULL,
  `ProductCode` int(10) UNSIGNED ZEROFILL DEFAULT NULL,
  `Qty` int(11) DEFAULT NULL,
  `PriceEach` decimal(19,0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `order_product`
--

INSERT INTO `order_product` (`ID`, `OrderID`, `ProductCode`, `Qty`, `PriceEach`) VALUES
(0000000001, 0000000001, 0000000001, 2, 35000),
(0000000002, 0000000001, 0000000003, 1, 20000),
(0000000003, 0000000002, 0000000002, 1, 30000);

-- --------------------------------------------------------

--
-- Table structure for table `payment`
--

CREATE TABLE `payment` (
  `CheckNum` varchar(255) NOT NULL,
  `CustomerID` int(10) UNSIGNED ZEROFILL DEFAULT NULL,
  `PaymentDate` datetime DEFAULT NULL,
  `Amount` decimal(19,0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `payment`
--

INSERT INTO `payment` (`CheckNum`, `CustomerID`, `PaymentDate`, `Amount`) VALUES
('CHK001', 0000000001, '2024-11-05 00:00:00', 70000),
('CHK002', 0000000002, '2024-11-16 00:00:00', 30000);

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `Code` int(10) UNSIGNED ZEROFILL NOT NULL,
  `ProductlineID` int(10) UNSIGNED ZEROFILL DEFAULT NULL,
  `Name` varchar(255) DEFAULT NULL,
  `Scale` int(11) DEFAULT NULL,
  `Vendor` varchar(255) DEFAULT NULL,
  `PdtDescription` varchar(255) DEFAULT NULL,
  `QtyInStock` int(11) DEFAULT NULL,
  `BuyPrice` decimal(19,0) DEFAULT NULL,
  `MSRP` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`Code`, `ProductlineID`, `Name`, `Scale`, `Vendor`, `PdtDescription`, `QtyInStock`, `BuyPrice`, `MSRP`) VALUES
(0000000001, 0000000001, '1969 Ford Mustang', 1, 'Ford', 'A classic Ford Mustang model.', 100, 25000, '35000.00'),
(0000000002, 0000000001, '1957 Chevy Corvette', 1, 'Chevrolet', 'A vintage Chevrolet Corvette.', 50, 20000, '30000.00'),
(0000000003, 0000000002, 'Harley Davidson Chopper', 1, 'Harley Davidson', 'A stylish Harley Davidson bike.', 75, 15000, '20000.00'),
(0000000004, 0000000003, 'Boeing 747', 1, 'Boeing', 'A large commercial airplane.', 10, 80000000, '100000000.00'),
(0000000005, 0000000001, 'Smartphone', 1, 'Xiaomi', 'This is brand new smartphone', 30, 5000, '70000.0'),
(0000000006, 0000000001, 'Smartwatch', 2, 'Samsung', 'Brand new smartwatch', 50, 800, '89999.0');

-- --------------------------------------------------------

--
-- Table structure for table `productline`
--

CREATE TABLE `productline` (
  `ID` int(10) UNSIGNED ZEROFILL NOT NULL,
  `DescInText` varchar(255) DEFAULT NULL,
  `DescInHTML` varchar(255) DEFAULT NULL,
  `Image` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `productline`
--

INSERT INTO `productline` (`ID`, `DescInText`, `DescInHTML`, `Image`) VALUES
(0000000001, 'Classic Cars', '<p>Classic Cars Description</p>', 'classic_cars.jpg'),
(0000000002, 'Motorcycles', '<p>Motorcycles Description</p>', 'motorcycles.jpg'),
(0000000003, 'Planes', '<p>Planes Description</p>', 'planes.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `ID` int(10) UNSIGNED ZEROFILL NOT NULL,
  `EmployeeID` int(10) UNSIGNED ZEROFILL DEFAULT 0000000001,
  `Username` varchar(255) NOT NULL,
  `Password` varchar(255) NOT NULL,
  `Email` varchar(255) DEFAULT NULL,
  `Role` varchar(50) DEFAULT NULL,
  `CreatedAt` datetime DEFAULT current_timestamp(),
  `UpdatedAt` datetime DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`ID`, `EmployeeID`, `Username`, `Password`, `Email`, `Role`, `CreatedAt`, `UpdatedAt`) VALUES
(0000000001, 0000000001, 'admin', 'admin', 'jsmith@example.com', 'Admin', '2024-11-24 11:50:40', '2024-11-24 18:06:26'),
(0000000002, 0000000002, 'jdoe', '123', 'jdoe@example.com', 'User', '2024-11-24 11:50:40', '2024-11-24 13:15:45'),
(0000000003, 0000000003, 'cbrown', '123', 'cbrown@example.com', 'User', '2024-11-24 11:50:40', '2024-11-24 13:15:45');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `SalesRepEmployeeNum` (`SalesRepEmployeeNum`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `OfficeCode` (`OfficeCode`),
  ADD KEY `ReportsTo` (`ReportsTo`);

--
-- Indexes for table `office`
--
ALTER TABLE `office`
  ADD PRIMARY KEY (`Code`);

--
-- Indexes for table `order`
--
ALTER TABLE `order`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `CustomerID` (`CustomerID`);

--
-- Indexes for table `order_product`
--
ALTER TABLE `order_product`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `OrderID` (`OrderID`),
  ADD KEY `ProductCode` (`ProductCode`);

--
-- Indexes for table `payment`
--
ALTER TABLE `payment`
  ADD PRIMARY KEY (`CheckNum`),
  ADD KEY `CustomerID` (`CustomerID`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`Code`),
  ADD KEY `ProductlineID` (`ProductlineID`);

--
-- Indexes for table `productline`
--
ALTER TABLE `productline`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `Username` (`Username`),
  ADD KEY `EmployeeID` (`EmployeeID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `ID` int(10) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `employee`
--
ALTER TABLE `employee`
  MODIFY `ID` int(10) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `office`
--
ALTER TABLE `office`
  MODIFY `Code` int(10) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `order`
--
ALTER TABLE `order`
  MODIFY `ID` int(10) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `order_product`
--
ALTER TABLE `order_product`
  MODIFY `ID` int(10) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `Code` int(10) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `productline`
--
ALTER TABLE `productline`
  MODIFY `ID` int(10) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `ID` int(10) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=128;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `customer`
--
ALTER TABLE `customer`
  ADD CONSTRAINT `customer_ibfk_1` FOREIGN KEY (`SalesRepEmployeeNum`) REFERENCES `employee` (`ID`);

--
-- Constraints for table `employee`
--
ALTER TABLE `employee`
  ADD CONSTRAINT `employee_ibfk_1` FOREIGN KEY (`OfficeCode`) REFERENCES `office` (`Code`),
  ADD CONSTRAINT `employee_ibfk_2` FOREIGN KEY (`ReportsTo`) REFERENCES `employee` (`ID`);

--
-- Constraints for table `order`
--
ALTER TABLE `order`
  ADD CONSTRAINT `order_ibfk_1` FOREIGN KEY (`CustomerID`) REFERENCES `customer` (`ID`);

--
-- Constraints for table `order_product`
--
ALTER TABLE `order_product`
  ADD CONSTRAINT `order_product_ibfk_1` FOREIGN KEY (`OrderID`) REFERENCES `order` (`ID`),
  ADD CONSTRAINT `order_product_ibfk_2` FOREIGN KEY (`ProductCode`) REFERENCES `product` (`Code`);

--
-- Constraints for table `payment`
--
ALTER TABLE `payment`
  ADD CONSTRAINT `payment_ibfk_1` FOREIGN KEY (`CustomerID`) REFERENCES `customer` (`ID`);

--
-- Constraints for table `product`
--
ALTER TABLE `product`
  ADD CONSTRAINT `product_ibfk_1` FOREIGN KEY (`ProductlineID`) REFERENCES `productline` (`ID`);

--
-- Constraints for table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `user_ibfk_1` FOREIGN KEY (`EmployeeID`) REFERENCES `employee` (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
