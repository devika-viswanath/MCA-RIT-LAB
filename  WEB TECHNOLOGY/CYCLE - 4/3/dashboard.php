<?php
session_start();
require 'db_connect.php';

if (!isset($_SESSION['user_id'])) {
    header("Location: login.php");
    exit();
}

$user_id = $_SESSION['user_id'];
$sql = "SELECT * FROM students WHERE id = ?";
$stmt = $conn->prepare($sql);
$stmt->bind_param("i", $user_id);
$stmt->execute();
$result = $stmt->get_result();
$user = $result->fetch_assoc();
?>

<!DOCTYPE html>
<html>
<body>
    <h2>Welcome, <?php echo htmlspecialchars($user['name']); ?></h2>
    
    <h3>Your Profile</h3>
    <p>Email: <?php echo htmlspecialchars($user['email']); ?></p>
    
    <a href="login.php">Logout</a>
</body>
</html>