<?php

require_once("Con.php");
class JsonMHotel {
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
            $queryMarker = "SELECT * FROM hotel";
            $getData = $conn->prepare($queryMarker);
            $getData->execute();
            $result = $getData->fetchAll(PDO::FETCH_ASSOC);
            foreach($result as $data){
                array_push($response,
                    array(
                        'nama_hotel'=>$data['nama'],
                        'latitude'=>$data['longitude'],
                        'longitude'=>$data['latitude'],
                        'keterangan'=>$data['keterangan'])
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
$location = new JsonMHotel();
$location->getMarkers();

?>