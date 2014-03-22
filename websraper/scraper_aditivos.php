<?php

  // From web
  //$html = file_get_contents('http://www.e-aditivos.com');
  
  // From the local copy
  $html = file_get_contents('aditivos/data.html');

  $dom = new DOMDocument();  
  libxml_use_internal_errors(TRUE);
  if(!empty($html)){
    $dom->loadHTML($html);
    libxml_clear_errors();  
    $tables = $dom->getElementsByTagName('table');
    $rows = $tables->item(0)->getElementsByTagName('tr');
      
    foreach ($rows as $row) {
        $node = $row->nodeValue;
        $values = split("\n", $node);
        echo "id: ".trim($values[0])."\n";
        echo "dangerous: ".trim($values[1])."\n";
        echo "name: ".trim($values[2])."\n";
        echo "type: ".trim($values[3])."\n";
        echo "----\n";
    }
  }

?>