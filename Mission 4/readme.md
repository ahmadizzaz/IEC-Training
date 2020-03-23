<h1>Mission 4</h1>
<h2>Exception Handling Cases</h2>
<ol>
  <li>GameNotFoundException<ul><li>This exception handles searches for a game/GET is called and there are no records with the specified id
    </li></ul></li>
  <li>NoDataFoundException<ul><li>This exception handles GET calls for the all games but there arent any records.</li></ul></li>
  <li>IdParamException<ul><li>This exception handles adding and updating of the id parameter(Id has the primary key and unique property in DB) ensuring that the this parameter is not empty or wont be duplicated</li></ul></li>
  <li>EmptyParamException<ul><li>This exception handles adding and updating of the name and platform parameters so that these parameters are not empty. </li></ul></li>
  
  
</ol>
