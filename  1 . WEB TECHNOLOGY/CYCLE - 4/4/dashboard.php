<?php
session_start();

if (!isset($_SESSION['student'])) {
    header("Location: login.php");
    exit();
}

$student = $_SESSION['student'];
?>

<!DOCTYPE html>
<html>
<body>
    <h2>Welcome, <?php echo htmlspecialchars($student['name']); ?></h2>
    
    <h3>Your Profile</h3>
    <p>Email: <?php echo htmlspecialchars($student['email']); ?></p>
    <p>Date of Birth: <?php echo htmlspecialchars($student['dob']); ?></p>
    
    <a href="login.php?logout=true">Logout</a>
</body>
</html>