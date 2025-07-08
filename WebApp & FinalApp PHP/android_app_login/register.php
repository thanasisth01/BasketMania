<?php
if(isset($_POST['name']) && isset($_POST['email']) && isset($_POST['password'])){
    require_once "conn.php";
    require_once "validate.php";
    $name = $_POST['name'];
    $email = $_POST['email'];
    $password = $_POST['password'];
    if($_POST['name'] == 'admin' && $_POST['password'] == 'admin'){
        $admin = 1;
        $sql = "insert into users values('', '$name', '$password', '$email', '$admin')";
    }
    else{
        $admin = 0;
        $sql = "insert into users values('', '$name', '$password', '$email', '$admin')";

    }
    // $query = "INSERT INTO users ( name, email, password, admin) VALUES ( '$name', '$email', '$password', '$admin)";
    if(!$conn->query($sql)){
        echo "failure";
    } else {
        echo "success";
    }
}


?>
