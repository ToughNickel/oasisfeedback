<?php
echo "Email : ".$_GET['email']." and description : ".$_GET['description'];
$email = $_GET['email'];
$feed = $_GET['description'];

$db = mysqli_connect("localhost","id4767136_toughnickel","nikhil@443*","id4767136_feedbacks") or die("Failed to connect");

$sql = "INSERT INTO entries (email,feed) values ('$email','$feed')";

if(mysqli_query($db,$sql)){
    echo "\nRecord Added successfully";
}else{
    echo "\nFailed Badly!!";
}
?>
