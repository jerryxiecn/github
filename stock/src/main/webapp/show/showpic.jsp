<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<script type="text/javascript">
$(function(){
    var x = [];//X轴
    var y = [];//Y轴
    var xtext = [];//X轴TEXT
    var color = ["gray","pink","red","blue","yellow","green","#fff"];
    $.ajax({
        type:'get',
        url:'/stock/chart',//请求数据的地址
        success:function(data){
            var json = eval("("+data+")");
            var s = 1;
            for(var key in json.list){
                json.list[key].y = json.list[key].money; //给Y轴赋值
                xtext = json.list[key].id;//给X轴TEXT赋值
                json.list[key].color= color[key];
            }
            
            chart.series[0].setData(json.list);//数据填充到highcharts上面
            
            for(var key in json.list){
                json.list[key].y = json.list[key].shindex; //给Y轴赋值
                xtext = json.list[key].id;//给X轴TEXT赋值
                json.list[key].color= color[key];
            }            
            chart.series[1].setData(json.list);//数据填充到highcharts上面
        },
        error:function(e){
        } 
    });
    var chart = new Highcharts.Chart({
        chart:{
            renderTo:'container',
            type:'spline' //显示类型 柱形
        },
        title:{
            text:'数据曲线图' //图表的标题
        },
        xAxis:{
            categories:xtext
        },
        yAxis:[{ //第一个Y轴，序号为0
            labels: {
                format: '{value}',
                style: {
                    color: '#89A54E'
                }
            },
            title: {
                text: '指数',
                style: {
                    color: '#89A54E'
                }
            }
        }, { //第二个Y轴，序号为1
            title: {
                text: '资金',
                style: {
                    color: '#4572A7'
                }
            },
            labels: {
                format: '{value} ￥',
                style: {
                    color: '#4572A7'
                }
            },
            opposite: true
        }],
        series:[{ //第二个Y轴的数据
            name: '资金',
            color: '#4572A7',
            type: 'spline',
            yAxis: 1,//坐标轴序号
                tooltip: {
                valueSuffix: ' ￥'
            }
        }, { //第一个Y轴的数据
            name: '指数',
            color: '#89A54E',
            type: 'spline',
               tooltip: {
                valueSuffix: ' '
            }
        }]
    });
});
</script>
 <div>
     <div id="container" style="width: 800px; height: 400px; margin: 0 auto">
     </div>
 </div>