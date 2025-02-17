<?php
$servername = "localhost";
$username = "root";  // default user for localhost
$password = "";  // default password for localhost
$dbname = "user_auth";

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);

// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}
?>
