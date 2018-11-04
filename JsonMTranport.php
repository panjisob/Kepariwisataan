<?php

require_once("Con.php");
class JsonMFasilitas {
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
            $queryMarker = "SELECT * FROM transportasi";
            $getData = $conn->prepare($queryMarker);
            $getData->execute();
            $result = $getData->fetchAll(PDO::FETCH_ASSOC);
            foreach($result as $data){
                array_push($response,
                    array(
                        'layanan_transportasi'=>$data['layanan_transportasi'],
                        'latitude'=>$data['x'],
                        'longitude'=>$data['y'],
                        'keterangan'=>$data['alamat'])
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
$location = new JsonMFasilitas();
$location->getMarkers();

?>