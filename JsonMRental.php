<?php

require_once("Con.php");
class JsonMRental {
    function getMarkers(){
        //buat koneksinya
        $connection = new Con();
        $conn = $connection->getConnection();
        //buat responsenya
        $response = array();
        $code = "code";
        $message = "message";
        try{
            //tampilkan semua data dari mysql
            $queryMarker = "SELECT * FROM rentalcar";
            $getData = $conn->prepare($queryMarker);
            $getData->execute();
            $result = $getData->fetchAll(PDO::FETCH_ASSOC);
            foreach($result as $data){
                array_push($response,
                    array(
                        'id'=>$data['id'],
                        'rent_car'=>$data['rent_car'],
                        'latitude'=>$data['x'],
                        'longitude'=>$data['y'],
                        'keterangan'=>$data['alamat'],
                        'no_hp'=>$data['no_hp'])
                    );
            }
        }catch (PDOException $e){
            echo "Failed displaying data".$e->getMessage();
        }
        //buatkan kondisi jika berhasil atau tidaknya
        if($queryMarker){
            echo json_encode(
                array("data"=>$response,$code=>1,$message=>"Success")
            );
        }else{
            echo json_encode(
                array("data"=>$response,$code=>0,$message=>"Failed displaying data")
            );
        }
    }
}
$location = new JsonMRental();
$location->getMarkers();

?>