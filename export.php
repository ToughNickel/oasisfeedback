<?php

$conn = new mysqli('localhost', 'id4767136_toughnickel', 'nikhil@443*');  
mysqli_select_db($conn, 'id4767136_feedbacks');  
  
$setSql = "SELECT `email`,`date`,`feed`,`Location` FROM `entries`";  
$setRec = mysqli_query($conn, $setSql);  
  
$columnHeader = '';  
$columnHeader = "Email" . "\t" . "Date" . "\t" . "Feedback" . "\t" . "Location" . "\t";  
  
$setData = '';  
  
while ($rec = mysqli_fetch_row($setRec)) {  
    $rowData = '';  
    foreach ($rec as $value) {  
        $value = '"' . $value . '"' . "\t";  
        $rowData .= $value;  
    }  
    $setData .= trim($rowData) . "\n";  
}  
  
  
header("Content-type: application/octet-stream");  
header("Content-Disposition: attachment; filename=User_Detail_Report.xls");  
header("Pragma: no-cache");  
header("Expires: 0");  
  
echo ucwords($columnHeader) . "\n" . $setData . "\n";

?>
