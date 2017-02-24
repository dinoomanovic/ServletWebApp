$(document).ready(function () {
    var date = new Date();
    $('.copyright').html(date.getFullYear());

});

function checkBrowser() {
    if ('localStorage' in window && window['localStorage'] !== null) {
        return true;
    } else {
        return false;
    }
}

function getUnits()
{
    return "metric";
}

function getOpenWeatherAPPID()
{
    return "83a06ae742e9bb9a8c326a268fc9e506";
}

function getCity()
{
    var cityList = getLocalStorage("countryList", "");
    
    console.log(cityList);
    return cityList;
}


function setLocalStorage(key, value)
{
    if (checkBrowser())
    {
        localStorage.setItem(key, value);
    }
}

function getLocalStorage(key, defValue)
{
    if (checkBrowser())
    {
        var value = localStorage.getItem(key);
        if (value !== null)
        {
            return value;
        }
    }

    return defValue;
}

function removeLocalStorage(key)
{
    if (checkBrowser())
    {
        localStorage.removeItem(key);
    }
}
            function getDaysCount()
{
    if (checkBrowser())
    {
        var cnt = localStorage.getItem("weather_cnt");
        if (cnt !== null)
        {
            return parseInt(cnt);
        }
    }
    return 4;
}