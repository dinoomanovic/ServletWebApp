$(document).ready(function () {
    showForecast();
    showCurrentWeather();
});

function showCurrentWeather()
{
    $.ajax({
        url: "http://api.openweathermap.org/data/2.5/weather",
        dataType: 'json',
        data: {APPID: getOpenWeatherAPPID(), "units": getUnits(), "q": getCity()},
    }).done(function (data, textStatus, jqXHR) {
        displayWeather(data);
    }).fail(function (jqXHR, textStatus, errorThrown) {
        alert(jqXHR.responseText);
    });
}

function displayWeather(data)
{
    var icon = "http://openweathermap.org/img/w/" + data.weather[0].icon + ".png";

    var cont = $(".js-current-weather-result");

    $(".js-icon", cont).attr("src", icon);
    $(".js-temp", cont).text(data.main.temp);
    $(".js-humidity", cont).text(data.main.humidity);
    $(".js-pressure", cont).text(data.main.pressure);
    $(".js-speed", cont).text(data.wind.speed);
    $(".js-place", cont).text(data.name);
    $(".js-lat", cont).text(data.coord.lat);
    $(".js-long", cont).text(data.coord.lon);


}

function showForecast() {
    $.ajax({
        url: "http://api.openweathermap.org/data/2.5/forecast/daily",
        dataType: 'json',
        data: {APPID: getOpenWeatherAPPID(), "units": getUnits(), "cnt": getDaysCount(), "q": getCity()},
    }).done(function (data, textStatus, jqXHR) {
        displayForecast(data);
    }).fail(function (jqXHR, textStatus, errorThrown) {
        alert(jqXHR.responseText);
    });
}

function displayForecast(data)
{
    var list = data.list;

    $.each(list, function (i, item) {

        var icon = "http://openweathermap.org/img/w/" + item.weather[0].icon + ".png";

        var minTemp = item.temp.min;
        var maxTemp = item.temp.max;

        var date = new Date();
        date.setDate(date.getDate() + i);
        $(".js-weather-result").append(createItem(icon, minTemp, maxTemp, date.toDateString()));
    });
}

function createItem(icon, minTemp, maxTemp, date)
{
    var item = '<div class="col-lg-3 col-xs-12 weather-item">' +
            '<div class="row text-center">' +
            '   <div class="col-xs-12">' +
            '      <span class="js-date">DATE</span>' +
            ' </div>' +
            '<div class="col-xs-12">' +
            '   <img class="js-icon" src="" alt="icon"/>' +
            '</div>' +
            '<div class="col-xs-12">' +
            '   <span>min: <span class="js-min"></span></span> <br>  <span>max : <span  class="js-max"></span></span>' +
            '</div>' +
            '</div>' +
            ' </div> ';
    var $item = $(item);

    $(".js-icon", $item).attr("src", icon);
    $(".js-min", $item).text(minTemp);
    $(".js-max", $item).text(maxTemp);
    $(".js-date", $item).text(date);

    return $item;

}




