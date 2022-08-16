var elements = document.getElementsByClassName("graphics");
var elementsTime = document.getElementsByClassName("time");
var numbers = [];
var numbersTime = [];
for (let i = 0; i < elements.length; i++) {
     numbers.push(elements[i].value);
}
for (let i = 0; i < elementsTime.length; i++) {
    numbersTime.push(elementsTime[i].getAttribute("value"));
console.log(elementsTime[i].getAttribute("value"))

}

var options = {
          series: [{
            name: "Desktops",
            data: numbers
        }],
          chart: {
          height: 350,
          type: 'line',
          zoom: {
            enabled: false
          }
        },
        dataLabels: {
          enabled: false
        },
        stroke: {
          curve: 'straight'
        },
        title: {
          text: 'Summing numbers for date-time',
          align: 'left'
        },
        grid: {
          row: {
            colors: ['#f3f3f3', 'transparent'],
            opacity: 0.5
          },
        },
        xaxis: {
          categories: numbersTime,
        }
        };

        var chart = new ApexCharts(document.querySelector("#chart"), options);
        chart.render();
