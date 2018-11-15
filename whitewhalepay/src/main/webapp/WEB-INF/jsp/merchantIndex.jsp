<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	int amount=11;
%>
<!DOCTYPE html>
<html>
  <head>
    <meta name="description" content="Vali is a responsive and free admin theme built with Bootstrap 4, SASS and PUG.js. It's fully customizable and modular.">
    <!-- Twitter meta-->
    <meta property="twitter:card" content="summary_large_image">
    <meta property="twitter:site" content="@pratikborsadiya">
    <meta property="twitter:creator" content="@pratikborsadiya">
    <!-- Open Graph Meta-->
    <meta property="og:type" content="website">
    <meta property="og:site_name" content="Vali Admin">
    <meta property="og:title" content="Vali - Free Bootstrap 4 admin theme">
    <meta property="og:url" content="http://pratikborsadiya.in/blog/vali-admin">
    <meta property="og:image" content="http://pratikborsadiya.in/blog/vali-admin/hero-social.png">
    <meta property="og:description" content="Vali is a responsive and free admin theme built with Bootstrap 4, SASS and PUG.js. It's fully customizable and modular.">
    <title>白鲸支付</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Main CSS-->
    <link rel="stylesheet" type="text/css" href="<%=basePath%>css/main.css">
    <!-- Font-icon css-->
    <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
  </head>
  <body class="app sidebar-mini rtl">
    <!-- Navbar-->
    <header class="app-header"><a class="app-header__logo" href="index.html">白鲸支付</a>
      <!-- Sidebar toggle button--><a class="app-sidebar__toggle" href="#" data-toggle="sidebar" aria-label="Hide Sidebar"></a>
      <!-- Navbar Right Menu-->
      <ul class="app-nav">
        <!-- User Menu-->
        <li class="dropdown"><a class="app-nav__item" href="#" data-toggle="dropdown" aria-label="Open Profile Menu"><i class="fa fa-user fa-lg"></i></a>
          <ul class="dropdown-menu settings-menu dropdown-menu-right">
            <li><a class="dropdown-item" href="page-user.html"><i class="fa fa-user fa-lg"></i>个人信息</a></li>
            <li><a class="dropdown-item" href="page-login.html"><i class="fa fa-sign-out fa-lg"></i> 	登出</a></li>
          </ul>
        </li>
      </ul>
    </header>
    <!-- Sidebar menu-->
    <div class="app-sidebar__overlay" data-toggle="sidebar"></div>
    <aside class="app-sidebar">
      <div class="app-sidebar__user"><img class="app-sidebar__user-avatar" src="https://s3.amazonaws.com/uifaces/faces/twitter/jsa/48.jpg" alt="User Image">
        <div>
          <p class="app-sidebar__user-name">张 泷</p>
          <p class="app-sidebar__user-designation">商 户</p>
        </div>
      </div>
      <ul class="app-menu">
        <li><a class="app-menu__item active" href="<%=basePath%>merchantIndex#"><i class="app-menu__icon fa fa-home"></i><span class="app-menu__label">首页</span></a></li>
        <li><a class="app-menu__item" href="<%=basePath%>merchantOrder#"><i class="app-menu__icon fa fa-table"></i><span class="app-menu__label">订单信息</span></a></li>
		<li><a class="app-menu__item" href="<%=basePath%>merchantInfo#"><i class="app-menu__icon fa fa-address-book"></i><span class="app-menu__label">商户配置</span></a></li>
      </ul>
    </aside>
    <main class="app-content">
    
      <div class="row">
        <div class="col-md-12 col-lg-12">
          <div class="tile">
            <p>尊敬的用户：</p>
            <p>您好</p>
            <p>您好您好您好您好您好您好您好您好您好您好您好您好您好您好</p>
            <p>您好您好您好您好您好您好您好您好您好您好您好您好您好您好您好您好您好您好您好您好您好您好您好您好您好您好您好您好</p>
            <p>您好您好您好您好您好您好您好您好您好您好您好您好您好您好您好您好您好您好您好您好您好您好您好您好您好您好您好您好您好您好您好您好您好您好您好您好您好您好您好您好您好您好您好您好您好您好您好您好您好您好您好您好您好您好您好您好</p>
            <p>任何疑问或建议吗，请与我们沟通！</p>
          </div>
        </div>
      </div>
      
      <div class="row">
        <div class="col-md-6 col-lg-3">
          <div class="widget-small primary coloured-icon"><i class="icon fa fa-usd fa-3x"></i>
            <div class="info">
              <h4>账户余额</h4>
              <p><b><%=amount %></b></p>
            </div>
          </div>
        </div>
        <div class="col-md-6 col-lg-3">
          <div class="widget-small primary coloured-icon"><i class="icon fa fa-align-justify fa-3x"></i>
            <div class="info">
              <h4>钱包地址</h4>
              <p><b>5</b></p>
            </div>
          </div>
        </div>
      </div>
      
    
      </div>
    </main>
    <!-- Essential javascripts for application to work-->
    <script src="<%=basePath%>js/jquery-3.2.1.min.js"></script>
    <script src="<%=basePath%>js/popper.min.js"></script>
    <script src="<%=basePath%>js/bootstrap.min.js"></script>
    <script src="<%=basePath%>js/main.js"></script>
    <!-- The javascript plugin to display page loading on top-->
    <script src="<%=basePath%>js/plugins/pace.min.js"></script>
    <!-- Page specific javascripts-->
    <script type="text/javascript" src="<%=basePath%>js/plugins/chart.js"></script>
  </body>
</html>