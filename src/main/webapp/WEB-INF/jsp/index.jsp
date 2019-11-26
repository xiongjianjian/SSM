<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <meta charset="utf-8">
<%--
    <meta http-equiv="Refresh" content="3">
--%>
    <title>NicePage demo</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

    <link href="${pageContext.request.contextPath}/static/css/layui.css" type="text/css" rel="stylesheet">

</head>
<BODY>

<center style="padding-top: 40px">

    <a style="font-size: 70px;font-weight: 500">JSON自动分页 <span class="layui-badge layui-bg-blue">DEMO</span><%@include file="logout.jsp"%></a>
    </br>


    <div style="width: 80%;padding-top: 20px">
        <security:authorize access="hasAuthority('ROLE_ADMIN')">Only admin can see!!!</security:authorize>

        <blockquote class="layui-elem-quote">#基于强大的layui 框架,通过扩展nicePage.js实现JSON数据格式的自动表格分页和跳转功能,配置简单,上手速度快，兼容IE5+。
        </blockquote>
        <!--以下为两个必须div元素-->
        <div id="table"></div>
        <div id="pageBar"></div>
    </div>

</center>

<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
</fieldset>

<pre class="layui-code">
</pre>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/layui.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/nicePage.js"></script>
<script type="text/javascript">
    //标准json格式 目前只支持[{a:b,c:d},{a:b,c:d}]此种格式
    var json;
    function reqs() {
        $.ajax({
            url: "${pageContext.request.contextPath}/student/findAll",//获取数据的URL
            /*data:JSON.stringify({
                'wJsona':"kkk",
                'wjsonb':12,
                'wjsonc':80,
            }),*/
            type: "POST",//HTTP请求方法
            async: false,
            dataType: 'JSON',//获取数据执行方式
            success: function (data) {
                json = data;
            },
            error: function (err) {
                alert('无权限访问数据！');
            }
        });
    }
    reqs();
	//setTimeout(function () {location.reload()},1000)
    /*
        setInterval(reqs,5000);

    */
    //setInterval(reqs(), 3000);

    //nameList与widthList的数组长度要一致
    var nameList = ['id', '班级编号', '年龄', '性别', '班级', '姓名'] //table的列名
    var widthList = [100, 100, 100, 100, 100, 100] //table每列的宽度

    /**
     * 初始化设置nicepage组件    v1.0
     *-------------------------------------------------------------
     * 进行数据组装,与layui交互进行元素渲染
     *-------------------------------------------------------------
     * @param    {string}  table     table的div id
     * @param    {string}  bar     底部分页的div id
     * @param    {int}  limit     每页默认行数
     * @param    {string}  color     底部分页的颜色
     * @param    {array}  layout     底部分页的布局,具体可参考layui api
     *
     * @date     2018-10-19
     * @author   Thomas.dz <hzdz163@163.com>
     */
    $(function () {
        nicePage.setCfg({
            table: 'table',
            bar: 'pageBar',
            limit: 20,
            color: '#1E9FFF',
            layout: ['count', 'prev', 'page', 'next', 'limit', 'skip']
        });
    });//初始化完成
</script>

<div style="text-align:center;margin:50px 0; font:normal 14px/24px 'MicroSoft YaHei';">
    <p>适用浏览器：IE8、360、FireFox、Chrome、Safari、Opera、傲游、搜狗、世界之窗.</p>
    <p>来源：<a href="http://sc.chinaz.com/" target="_blank">站长素材</a></p>
</div>

</body>
</html>