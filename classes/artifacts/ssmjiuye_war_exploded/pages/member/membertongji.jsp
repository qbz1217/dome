<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ page isELIgnored="false" %> 
<%
String path = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>学生 </title>
    <!-- Bootstrap -->
	<script src="<%=path %>/js/jquery.min.js"></script>
    <link href="<%=path %>/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=path %>/css/my.css" rel="stylesheet">
	<script src="<%=path %>/js/bootstrap.min.js"></script>
<script  src="<%=path %>/js/laydate/laydate.js"></script>
<script type="text/javascript" src="<%=path %>/js/echarts.min.js"></script>

	<div id="chart1" style="width: 500px;height:500px;float: left;"></div>

	<div id="chart2" style="width: 500px;height:500px;float: left;"></div>
	<div id="chart3" style="width: 500px;height:500px;float: left;"></div>

	<script type="text/javascript">
	var mychart1=echarts.init(document.getElementById('chart1'),'light');
	// 指定图表的配置项和数据
    var option = {
        title: {
            text: '求职学生学历统计'
        },
        tooltip: {},
        legend: {
            data:['人数']
        },
        xAxis: {
            data: ["大专","本科","研究生","博士"]
        },
        yAxis: {},
        series: [{
            name: '人数',
            type: 'bar',
            data: [${x1}, ${x2}, ${x3}, ${x4}]
        }]
    };
 // 使用指定的配置项和数据显示条形图表1。
    mychart1.setOption(option);

	 //显示扇形图表2
    var mychart2=echarts.init(document.getElementById('chart2'),'light');
    var option2 = {
        title: {
            text: '求职学生男女比例'
        },
        tooltip: {},
        series: [{
            type: 'pie',
            data: [
                {value:${str2}, name:'女生'},
                {value:${str1}, name:'男生'}
            ]
        }]
    };

    // 使用刚指定的配置项和数据显示图表。
    mychart2.setOption(option2);
    var mychart3=echarts.init(document.getElementById('chart3'),'light');
	// 指定图表的配置项和数据
    var option3 = {
        title: {
            text: '招聘类型统计'
        },
        tooltip: {},
        legend: {
            data:['人数']
        },
        xAxis: {
            data: ["全职","兼职"]
        },
        yAxis: {},
        series: [{
            name: '人数',
            type: 'bar',
            data: [${q1}, ${q2}]
        }]
    };
 // 使用指定的配置项和数据显示条形图表1。
    mychart3.setOption(option3);
//折线图
    </script>
    <div id="box" style="width: 600px;height: 600px;"></div>
    <script>
        //初始化ehcharts实例
        var myChart=echarts.init(document.getElementById("box"));
        //指定图表的配置项和数据
        var option4={
        //标题
        title:{
        text:'学生学历统计'
    },
        //工具箱
        //保存图片
        toolbox:{
        show:true,
        feature:{
        saveAsImage:{
        show:true
    }
    }
    },
        //图例-每一条数据的名字叫销量
        legend:{
        data:['人数']
    },
        //x轴
        xAxis:{
        data: ["大专","本科","研究生","博士"]
    },
        //y轴没有显式设置，根据值自动生成y轴
        yAxis:{},
        //数据-data是最终要显示的数据
        series:[{
        name:'人数',
        type:'line',
        data: [${x1}, ${x2}, ${x3}, ${x4}]
    }]
    };
        //使用刚刚指定的配置项和数据项显示图表
        myChart.setOption(option4);
</script>

</head>

