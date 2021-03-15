<%@ include file="head.jsp" %>
<%@page import="model.Motor" %>
<%@page import="model.Billing" %>
<% Motor data = (Motor) request.getAttribute("dataChangePage"); %>
<%@page import="java.util.ArrayList" %>
    <body>

        <!-- Begin page -->
        <div id="wrapper">

            <!-- Topbar Start -->
            <div class="navbar-custom">
                
                <!-- LOGO -->
                <div class="logo-box">
                    <a href="Home" class="logo text-center">
                        <span class="logo-lg">
                            <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" version="1.1" id="Layer_1" x="0px" y="0px" viewBox="0 0 376.5 99.86" style="enable-background:new 0 0 376.5 99.86;" xml:space="preserve" height="77px" width="200px">
                                <path d="M49.87,46.72c0-4.64-3.69-8.3-8.28-8.3h-3.6V55h3.6C46.17,55,49.87,51.34,49.87,46.72 M56.34,49.41l-5.87,10.13h11.7  L56.34,49.41z M56.34,44.02l5.83-10.13h-11.7L56.34,44.02z M62.79,46.72c0,4.62,3.69,8.28,8.28,8.28h3.6V38.41h-3.6  C66.48,38.41,62.79,42.07,62.79,46.72 M330.64,60.21c-1.34,3.39-3.02,5.01-6.84,5.01c-0.9,0-1.62-0.06-2.21-0.16V60.8  c0.53,0.09,1.28,0.19,1.68,0.19c1.28,0,2.08-0.5,2.74-2.08l0.4-1l-6.9-16.14h5.54l4.01,9.92l3.7-9.89h5.23L330.64,60.21   M308.87,53.9c-2.24,0-3.79-1.87-3.79-4.07s1.56-4.11,3.79-4.11c2.33,0,3.89,1.9,3.89,4.11S311.2,53.9,308.87,53.9 M317.86,58.16  V41.77h-5.01v2.36c-0.93-1.71-3.02-2.77-5.07-2.77c-4.7,0-7.81,3.64-7.81,8.46c0,4.79,3.23,8.18,7.87,8.18  c2.08,0,4.07-1.03,4.95-2.49v2.77c0,2.3-1.21,3.58-3.64,3.58c-2.15,0-3.33-1-3.55-2.46h-5.04c0.28,3.58,3.11,6.13,8.46,6.13  C314.96,65.53,317.86,62.85,317.86,58.16 M289.43,53.9c-2.3,0-3.79-1.84-3.79-4.07c0-2.24,1.49-4.11,3.79-4.11  c2.3,0,3.83,1.87,3.83,4.11C293.26,52.06,291.73,53.9,289.43,53.9 M289.43,58.28c5.6,0,8.93-3.89,8.93-8.46  c0-4.6-3.33-8.49-8.93-8.49c-5.54,0-8.9,3.89-8.9,8.49C280.53,54.39,283.89,58.28,289.43,58.28 M273.01,57.85h5.07V34.52h-5.07  V57.85z M261.62,53.9c-2.3,0-3.79-1.84-3.79-4.07c0-2.24,1.49-4.11,3.79-4.11c2.3,0,3.83,1.87,3.83,4.11  C265.45,52.06,263.93,53.9,261.62,53.9 M261.62,58.28c5.6,0,8.93-3.89,8.93-8.46c0-4.6-3.33-8.49-8.93-8.49  c-5.54,0-8.9,3.89-8.9,8.49C252.73,54.39,256.09,58.28,261.62,58.28 M234.25,57.85h5.07v-8.4c0-2.27,1.06-3.73,3.11-3.73  c2.18,0,2.86,1.34,2.86,3.27v8.86h5.07v-9.24c0-4.54-1.99-7.25-6.06-7.25c-2.39,0-4.14,1.06-5.04,2.74v-2.33h-5.01V57.85z   M214.94,57.85h5.07v-8.4c0-2.27,1.06-3.73,3.11-3.73c2.18,0,2.86,1.34,2.86,3.27v8.86h5.07v-9.24c0-4.54-1.99-7.25-6.06-7.25  c-2.36,0-4.07,1.06-4.98,2.74v-9.58h-5.07V57.85z M212.67,47.96c-0.62-3.73-3.39-6.62-8.24-6.62c-5.44,0-8.74,3.89-8.74,8.49  c0,4.57,3.3,8.46,8.74,8.46c4.85,0,7.62-2.89,8.24-6.62h-5.1c-0.44,1.4-1.52,2.33-3.11,2.33c-2.24,0-3.67-1.9-3.67-4.17  s1.43-4.2,3.67-4.2c1.59,0,2.64,0.93,3.08,2.33H212.67z M185.73,44.94c1.93,0,3.17,1.21,3.36,3.11h-6.81  C182.47,46.09,183.84,44.94,185.73,44.94 M193.67,52.96h-4.82c-0.53,0.96-1.46,1.65-3.05,1.65c-2.3,0-3.45-1.46-3.55-3.48h11.69  c0.09-0.75,0.12-1.31,0.12-1.9c0-4.26-2.95-7.9-8.27-7.9c-5.47,0-8.46,3.83-8.46,8.49c0,4.63,3.02,8.46,8.52,8.46  C190.24,58.28,192.86,55.95,193.67,52.96 M164.21,41.77v3.98h2.52v6.53c0,4.42,2.11,5.82,5.94,5.82c1.4,0,2.46-0.12,3.17-0.25v-4.07  c-0.62,0.09-1.56,0.19-2.02,0.19c-1.31,0-2.02-0.44-2.02-2.05v-6.16h3.67v-3.98h-3.67v-4.76h-5.07v4.76H164.21z M157.34,54.89  c0,1.77,1.43,3.23,3.23,3.23c1.84,0,3.23-1.46,3.23-3.23c0-1.77-1.4-3.23-3.23-3.23C158.77,51.66,157.34,53.12,157.34,54.89   M144.93,58.25c6.44,0,9.95-3.86,10.64-8.77h-5.32c-0.5,2.33-2.43,4.07-5.19,4.07c-4.01,0-6.1-3.2-6.1-6.9c0-3.7,2.08-6.9,6.1-6.9  c2.77,0,4.7,1.74,5.19,4.07h5.32c-0.68-4.91-4.2-8.77-10.64-8.77c-7.18,0-11.35,5.47-11.35,11.6S137.75,58.25,144.93,58.25   M127.48,57.85h6.16l-7.25-11.26l7.18-11.13h-6.03l-4.45,7.37l-4.51-7.37h-6.13l7.22,11.13l-7.28,11.26h6l4.57-7.46L127.48,57.85z   M100.77,39.99c4.14,0,6.5,3.23,6.5,6.66c0,3.39-2.36,6.66-6.5,6.66h-2.71V39.99H100.77z M92.8,57.85h8.21  c7.46,0,11.63-5.47,11.63-11.2s-4.2-11.2-11.63-11.2H92.8V57.85z"></path>
                            </svg>
                        </span>
                        <span class="logo-sm">
                            <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" version="1.1" id="Layer_1" x="0px" y="0px" viewBox="0 0 376.5 99.86" style="enable-background:new 0 0 376.5 99.86;" xml:space="preserve" height="77px" width="98px">
                                <path d="M49.87,46.72c0-4.64-3.69-8.3-8.28-8.3h-3.6V55h3.6C46.17,55,49.87,51.34,49.87,46.72 M56.34,49.41l-5.87,10.13h11.7  L56.34,49.41z M56.34,44.02l5.83-10.13h-11.7L56.34,44.02z M62.79,46.72c0,4.62,3.69,8.28,8.28,8.28h3.6V38.41h-3.6  C66.48,38.41,62.79,42.07,62.79,46.72 M330.64,60.21c-1.34,3.39-3.02,5.01-6.84,5.01c-0.9,0-1.62-0.06-2.21-0.16V60.8  c0.53,0.09,1.28,0.19,1.68,0.19c1.28,0,2.08-0.5,2.74-2.08l0.4-1l-6.9-16.14h5.54l4.01,9.92l3.7-9.89h5.23L330.64,60.21   M308.87,53.9c-2.24,0-3.79-1.87-3.79-4.07s1.56-4.11,3.79-4.11c2.33,0,3.89,1.9,3.89,4.11S311.2,53.9,308.87,53.9 M317.86,58.16  V41.77h-5.01v2.36c-0.93-1.71-3.02-2.77-5.07-2.77c-4.7,0-7.81,3.64-7.81,8.46c0,4.79,3.23,8.18,7.87,8.18  c2.08,0,4.07-1.03,4.95-2.49v2.77c0,2.3-1.21,3.58-3.64,3.58c-2.15,0-3.33-1-3.55-2.46h-5.04c0.28,3.58,3.11,6.13,8.46,6.13  C314.96,65.53,317.86,62.85,317.86,58.16 M289.43,53.9c-2.3,0-3.79-1.84-3.79-4.07c0-2.24,1.49-4.11,3.79-4.11  c2.3,0,3.83,1.87,3.83,4.11C293.26,52.06,291.73,53.9,289.43,53.9 M289.43,58.28c5.6,0,8.93-3.89,8.93-8.46  c0-4.6-3.33-8.49-8.93-8.49c-5.54,0-8.9,3.89-8.9,8.49C280.53,54.39,283.89,58.28,289.43,58.28 M273.01,57.85h5.07V34.52h-5.07  V57.85z M261.62,53.9c-2.3,0-3.79-1.84-3.79-4.07c0-2.24,1.49-4.11,3.79-4.11c2.3,0,3.83,1.87,3.83,4.11  C265.45,52.06,263.93,53.9,261.62,53.9 M261.62,58.28c5.6,0,8.93-3.89,8.93-8.46c0-4.6-3.33-8.49-8.93-8.49  c-5.54,0-8.9,3.89-8.9,8.49C252.73,54.39,256.09,58.28,261.62,58.28 M234.25,57.85h5.07v-8.4c0-2.27,1.06-3.73,3.11-3.73  c2.18,0,2.86,1.34,2.86,3.27v8.86h5.07v-9.24c0-4.54-1.99-7.25-6.06-7.25c-2.39,0-4.14,1.06-5.04,2.74v-2.33h-5.01V57.85z   M214.94,57.85h5.07v-8.4c0-2.27,1.06-3.73,3.11-3.73c2.18,0,2.86,1.34,2.86,3.27v8.86h5.07v-9.24c0-4.54-1.99-7.25-6.06-7.25  c-2.36,0-4.07,1.06-4.98,2.74v-9.58h-5.07V57.85z M212.67,47.96c-0.62-3.73-3.39-6.62-8.24-6.62c-5.44,0-8.74,3.89-8.74,8.49  c0,4.57,3.3,8.46,8.74,8.46c4.85,0,7.62-2.89,8.24-6.62h-5.1c-0.44,1.4-1.52,2.33-3.11,2.33c-2.24,0-3.67-1.9-3.67-4.17  s1.43-4.2,3.67-4.2c1.59,0,2.64,0.93,3.08,2.33H212.67z M185.73,44.94c1.93,0,3.17,1.21,3.36,3.11h-6.81  C182.47,46.09,183.84,44.94,185.73,44.94 M193.67,52.96h-4.82c-0.53,0.96-1.46,1.65-3.05,1.65c-2.3,0-3.45-1.46-3.55-3.48h11.69  c0.09-0.75,0.12-1.31,0.12-1.9c0-4.26-2.95-7.9-8.27-7.9c-5.47,0-8.46,3.83-8.46,8.49c0,4.63,3.02,8.46,8.52,8.46  C190.24,58.28,192.86,55.95,193.67,52.96 M164.21,41.77v3.98h2.52v6.53c0,4.42,2.11,5.82,5.94,5.82c1.4,0,2.46-0.12,3.17-0.25v-4.07  c-0.62,0.09-1.56,0.19-2.02,0.19c-1.31,0-2.02-0.44-2.02-2.05v-6.16h3.67v-3.98h-3.67v-4.76h-5.07v4.76H164.21z M157.34,54.89  c0,1.77,1.43,3.23,3.23,3.23c1.84,0,3.23-1.46,3.23-3.23c0-1.77-1.4-3.23-3.23-3.23C158.77,51.66,157.34,53.12,157.34,54.89   M144.93,58.25c6.44,0,9.95-3.86,10.64-8.77h-5.32c-0.5,2.33-2.43,4.07-5.19,4.07c-4.01,0-6.1-3.2-6.1-6.9c0-3.7,2.08-6.9,6.1-6.9  c2.77,0,4.7,1.74,5.19,4.07h5.32c-0.68-4.91-4.2-8.77-10.64-8.77c-7.18,0-11.35,5.47-11.35,11.6S137.75,58.25,144.93,58.25   M127.48,57.85h6.16l-7.25-11.26l7.18-11.13h-6.03l-4.45,7.37l-4.51-7.37h-6.13l7.22,11.13l-7.28,11.26h6l4.57-7.46L127.48,57.85z   M100.77,39.99c4.14,0,6.5,3.23,6.5,6.66c0,3.39-2.36,6.66-6.5,6.66h-2.71V39.99H100.77z M92.8,57.85h8.21  c7.46,0,11.63-5.47,11.63-11.2s-4.2-11.2-11.63-11.2H92.8V57.85z"></path>
                            </svg>
                        </span>
                    </a>
                </div>

                <ul class="list-unstyled topnav-menu topnav-menu-left m-0">
                    <li>
                        <button class="button-menu-mobile waves-effect waves-light">
                            <i class="fe-menu"></i>
                        </button>
                    </li>
        
                    
                </ul>
            </div>
            <!-- end Topbar -->

            <!-- ========== Left Sidebar Start ========== -->
            <div class="left-side-menu">

                <div class="slimscroll-menu">

                    <!--- Sidemenu -->
                    <div id="sidebar-menu">

                        <ul class="metismenu" id="side-menu">

                            <li class="menu-title">Function</li>
                            
                            <li class="mm-active">
                                <a href="javascript: void(0);" class="waves-effect active" aria-expanded="true">
                                    <i class="remixicon-motorbike-fill" aria-hidden="true"></i>
                                    <span> Motor Policy </span>
                                    <span class="menu-arrow"></span>
                                </a>
                                <ul class="nav-second-level mm-collapse mm-show" aria-expanded="false">
                                    <li class="mm-active">
                                        <a href="Home" class="active">Endorse Motor Policy</a>
                                    </li>
                                </ul>
                                <ul class="nav-second-level mm-collapse mm-show" aria-expanded="false">
                                    <li >
                                        <a href="Pending">Pending endorsement</a>
                                    </li>
                                </ul>
                            </li>
                        </ul>

                    </div>
                    <!-- End Sidebar -->

                    <div class="clearfix"></div>

                </div>
                <!-- Sidebar -left -->

            </div>
            <!-- Left Sidebar End -->

            <!-- ============================================================== -->
            <!-- Start Page Content here -->
            <!-- ============================================================== -->

            <div class="content-page">
                <div class="content">

                    <!-- Start Content-->
                    <div class="container-fluid">
                        
                        <!-- start page title -->
                        <div class="row">
                            <div class="col-12">
                                <div class="page-title-box">
                                    <div class="page-title-right">
                                        <ol class="breadcrumb m-0">
                                            <li class="breadcrumb-item"><a href="javascript: void(0);">Motor Policy</a></li>
                                            <li class="breadcrumb-item active">Endorse Motor Policy</li>
                                        </ol>
                                    </div>
                                    <h4 class="page-title">Endorse Motor Policy</h4>

                                </div>
                            </div>
                        </div>     
                        <!-- end page title --> 

                        <div class="row">
                            <div class="col-12">
                                <div class="card-box">
                                    <h4 class="header-title">Detail Motor Policy <%= request.getParameter("policyno") %></h4>
                                    <p id="desctable" class="sub-header">
                                        Enter all fieldd
                                    </p>
                                    <form action="" method="POST" class="parsley-form">
                                        <!-- Start fields -->
                                        <div class="form-group">
                                            <label>Policy No</label>
                                            <div>
                                                <input name="policyno" type="text" class="form-control" value="<%=data.getPolicyNo() %>" required="" data-parsley-maxlength="8" placeholder="Max 8 chars">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label>Inception Date</label>
                                            <div class="input-group">
                                                <div class="input-group-append">
                                                    <span class="input-group-text"><i aria-hidden="true"  class="ti-calendar"></i></span>
                                                </div>
                                                <input name="inceptiondate" type="text" value="<%=data.getInceptionDate() %>" class="form-control" required="" data-provide="datepicker" parsley-type="date" placeholder="dd/mm/yy" data-date-autoclose="true">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label>Effective Date</label>
                                            <div class="input-group">
                                                <div class="input-group-append">
                                                    <span class="input-group-text"><i aria-hidden="true" class="ti-calendar"></i></span>
                                                </div>
                                                <input name="effectivedate" type="text" value="<%=data.getEffectiveDate() %>" class="form-control" required="" data-provide="datepicker" parsley-type="date" placeholder="dd/mm/yy" data-date-autoclose="true">
                                                
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label>Expiry Date</label>
                                            <div class="input-group">
                                                <div class="input-group-append">
                                                    <span class="input-group-text"><i aria-hidden="true" class="ti-calendar"></i></span>
                                                </div>
                                                <input name="expirydate" value="<%=data.getExpiryDate() %>" type="text" class="form-control" required="" data-provide="datepicker" parsley-type="date" placeholder="dd/mm/yy" data-date-autoclose="true">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label>Policy Owner</label>
                                            <div>
                                                <input name="policyowner" value="<%=data.getPolicyOwner() %>" type="text" class="form-control" required="" data-parsley-maxlength="8" placeholder="Max 8 chars">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label>Engine No</label>
                                            <div>
                                                <input name="enghineno" value="<%=data.getEngineNo() %>" type="text" class="form-control" required="" data-parsley-maxlength="30" placeholder="1325ACEW">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label>Chassis No</label>
                                            <div>
                                                <input name="chassicno" type="text" value="<%=data.getChasisNo() %>" class="form-control" required="" data-parsley-maxlength="30" placeholder="C1411MF">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label>Vehicle Registration No</label>
                                            <div>
                                                <input name="vehicleregistrationno" value="<%=data.getVehicleRegistrationNo() %>" type="text" class="form-control" required="" data-parsley-maxlength="30" placeholder="51H-791.02">
                                            </div>
                                        </div>
                                        
                                        <div class="form-group">
                                            <label>Sum Insured</label>
                                            <div>
                                                <input data-parsley-type="number" step="0.1" value="<%=data.getSumInsured() %>" name="suminsured" type="number" class="form-control" required="" min="0" data-parsley-maxlength="17" placeholder="10,000,000.00">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label>Rate</label>
                                            <div>
                                                <input step="0.01" data-parsley-type="number" value="<%=data.getRate() %>" name="rate" type="number" class="form-control" required="" min="0" data-parsley-maxlength="4" placeholder="0.1">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label>Annual Premium</label>
                                            <div>
                                                <input data-parsley-type="number" value="<%=data.getAnnualPremium() %>" name="annualpremium" type="number" class="form-control" required="" data-parsley-maxlength="17">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label>Posted Premium</label>
                                            <div>
                                                <input data-parsley-type="number" value="<%=data.getPostedPremium() %>" name="postedpremium" type="number" class="form-control" required=""  data-parsley-maxlength="17">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label>Billing Currency</label>
                                            <div>
                                                <select name="billing" class="form-control">
                                                <%
                                                ArrayList<Billing> select = new ArrayList<Billing>();
                           						select = (ArrayList<Billing>) request.getAttribute("dataBillingChangePage");
                                                	for(Billing a : select){
                                                		
                                                %>
                                                    <option value="<%= a.getBilling() %>"><%= a.getBilling() %></option>

                                                <%}; %>
                                                </select>
                                            </div>
                                        </div>

                                        <div class="form-group mb-0">
                                            <div>
                                                <button type="submit" class="btn btn-primary waves-effect waves-light mr-1">
                                                    Save
                                                </button>
                                                <button type="button" onclick="" class="btn btn-primary waves-effect waves-light mr-1">
                                                    Refresh
                                                </button>
                                                <button type="reset" class="btn btn-secondary waves-effect waves-light">
                                                    Cancel
                                                </button>
                                            </div>
                                        </div>
                                    </form>
                                </div> <!-- end card-box -->
                            </div> <!-- end col -->
                        </div>
                        <!-- end row -->


                        
                        <!-- end row -->
                        
                    </div> <!-- container -->

                </div> <!-- content -->

                <!-- Footer Start -->
                <%@ include file="footer.jsp" %>
    </body>
</html>