<ul>Описание:
<li>Создать проект на Java с использованием Spring Boot</li>
<li>На Java разработать 2 контроллера (GET-получение тестовой страницы, POST-получение двух параметров в запросе, их суммирование и отправка результата)</li>
<li>Создать одну html-страницу с тремя элементами (2 input с типом number и button)</li>
<li>Создать JavaScript-файл с функцией, которая будет срабатывать при нажатии на элемент button, получать значения из двух input и отправлять их на POST-контроллер, после чего выводить результат любым способом пользователю.</li>
<li>Подключить разработанный JavaScript-файл на html-странице</li>
<li>Реализовать базовую-аутентификацию при входе на тестовую страницу.</li>
<li>Добавить любых CSS-стилей для элементов страницы.</li>
<li>Подключить на странице график (https://apexcharts.com/javascript-chart-demos/line-charts/basic/) и выводить на нём произвольные данные, полученные с POST-контроллера.</li>
</ul>

  <ul>Стэк:
  <li>Spring boot</li>
    <li>Spring web</li>
      <li>Spring security</li>
        <li>Spring jpa</li>
          <li>Spring validation</li>
          <li>Js+css+html</li>
          <li>Maven</li>
          <li>h2</li>         
    <li>Подключен Bootstrap5</li>
  <li>Подключен график</li>
  <li>Шаблонизатор Thymeleaf</li>
  </ul>
  
  <ul> Docker:
  <li>Dockerfile:Dockerfile in root or use <a href="https://hub.docker.com/repository/docker/granddfat/site">DockerHub</a> </li>
  </ul>
  
<ul>Вводная часть:
  <li>login/pasword : Admin,Admin в дальнейшем можно создавать других пользователей с правами, все права у роли ADMIN </li>
  <li>На главной странице есть nav bar, отображение распределено по ролям</li>
  <li>localhost:8080 : Предоставление данных для ввода и отображение графика(Отправляется два input`a методом POST, js обрабатывает и сумирует их, jpa записывает сумму в БД, выводится график с введенными ранее сумами)</li>
  </ul>
  
