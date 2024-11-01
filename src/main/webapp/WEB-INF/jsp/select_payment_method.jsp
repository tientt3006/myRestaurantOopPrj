<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
    
<c:set var="title" value="OOP Dinner - Select Payment Method" scope="page"/>
<%@ include file="head.jspf" %>
    
<body>
    <div class="wrapper">
        <!-- Header Section -->
        <c:set var="currentPage" value="select_payment_method" scope="page"/>
        <%@ include file="cus_header.jspf" %>
        
        <!-- Main Content -->
        <div class="main-container">
            <div class="login-container selent-pm-container" style="align-items: flex-start;">
                
                
                
<!--                HttpSession session = request.getSession();
                session.setAttribute("reservationDate", selectedDate);
                session.setAttribute("reservationTime", selectedTime);
                session.setAttribute("numberOfPeople", selectedPeopleCount); here are what inside servlet-->

                <div class="reser-detail-box login-box" style="color: white;">
                    <h2>Reservation Details</h2>
                    <!--<p style="text-align: center;">Please review your reservation details before proceeding with the payment.</p>-->
                    <p><strong>Selected Table(s):</strong> ${selectedTableNumber}</p>
                    <p><strong>Number of People:</strong> ${numberOfPeople}</p>
                    <p><strong>Date:</strong> ${reservationDate}</p>
                    <p><strong>Time:</strong> ${reservationTime}</p>
                    <p><strong>Branch:</strong> ${reservationBranch}</p>
                    <p><strong>Deposit Amount:</strong> ${depositAmount} $</p>
                </div>
                
                <div class="select-pm-box login-box">
                    <h2>Payment Method</h2>
                    <div class="error-message" style="color: red; text-align: center; margin-bottom: 10px;">
                        Your table may still be reserved by someone else at this time.
                    </div>
                    <br>
                    <form id="selectPmForm" action="${pageContext.request.contextPath}/select_payment_method" method="post">
                        
                        <div style="display: flex; gap: 60px;">
                            <label class="password-text" for="paymentMethod" style="flex: 1;">Payment Method:</label>
                            <label class="password-text" for="expMonth" style="flex: 1;">Expiration date:</label>
                        </div>
                        
                        <div style="display: flex; gap: 40px;">
                            
                            <select name="paymentMethod" id="paymentMethod" style="flex: 1;">
                                <option value="Visa">Visa</option>
                                <option value="MasterCard">MasterCard</option>
                                <option value="AmericanExpress">American Express</option>
                            </select>
                            
                            <div style="display: flex; gap: 10px; flex: 1;">
                                <select name="expMonth" id="expMonth" style="flex: 1;">
                                    <option value="01">01</option>
                                    <option value="02">02</option>
                                    <option value="03">03</option>
                                    <option value="04">04</option>
                                    <option value="05">05</option>
                                    <option value="06">06</option>
                                    <option value="07">07</option>
                                    <option value="08">08</option>
                                    <option value="09">09</option>
                                    <option value="10">10</option>
                                    <option value="11">11</option>
                                    <option value="12">12</option>
                                </select>

                                <select name="expYear" id="expYear" style="flex: 1;">
                                    <option value="2024">2024</option>
                                    <option value="2025">2025</option>
                                    <option value="2026">2026</option>
                                    <option value="2027">2027</option>
                                </select>
                            </div>
                        </div>
                        
                        <div style="display: flex; gap: 10px;">
                            <label class="password-text" for="cardNumber" style="flex: 1;">Card number:</label>
                            <label class="password-text" for="securityCode" style="flex: 1;">Security code:</label>
                        </div>
                        <div style="display: flex; gap: 10px;">
                            <input type="text" name="cardNumber" id="cardNumber" maxlength="16" style="flex: 1;" >
                            <input type="text" name="securityCode" id="securityCode" maxlength="3" style="flex: 1;" >
                        </div>
                        
                        <br>
                        <h2>Billing Information</h2>
                        <div style="display: flex; flex-direction: column; gap: 10px;">
                            <div style="display: flex; gap: 10px; align-items: center;">
                                <label class="password-text" for="firstName" style="width:  100px;">First name:</label>
                                <input type="text" name="firstName" id="firstName" style="flex: 1;">
                            </div>

                            <div style="display: flex; gap: 10px; align-items: center;">
                                <label class="password-text" for="lastName" style="width:  100px;">Last name:</label>
                                <input type="text" name="lastName" id="lastName" style="flex: 1;">
                            </div>

                            <div style="display: flex; gap: 10px; align-items: center;">
                                <label class="password-text" for="billingAddress" style="width:  100px;">Billing address:</label>
                                <input type="text" name="billingAddress" id="billingAddress" style="flex: 1;">
                            </div>

                            <div style="display: flex; gap: 10px; align-items: center;">
                                <label class="password-text" for="billingAddress2" style="width:  100px;">Billing address, line 2:</label>
                                <input type="text" name="billingAddress2" id="billingAddress2" style="flex: 1;">
                            </div>

                            <div style="display: flex; gap: 10px; align-items: center;">
                                <label class="password-text" for="city" style="width:  100px;">City:</label>
                                <input type="text" name="city" id="city" style="flex: 1;">
                            </div>

                            <div style="display: flex; gap: 10px; align-items: center;">
                                <label class="password-text" for="zipCode" style="width:  100px;">Zip or postal code:</label>
                                <input type="text" name="zipCode" id="zipCode" style="flex: 1;">
                            </div>

                            <div style="display: flex; gap: 10px; align-items: center;">
                                <label class="password-text" for="country" style="width:  100px;">Country:</label>
                                <select name="country" id="country" style="flex: 1;">
                                    <option value="Viet Nam">Viet Nam</option>
                                    <option value="United States">United States</option>
                                    <option value="Canada">Canada</option>
                                    <!-- Add other countries as needed -->
                                </select>
                            </div>

                            <div style="display: flex; gap: 10px; align-items: center;">
                                <label class="password-text" for="phoneNumber" style="width:  100px;">Phone number:</label>
                                <input type="text" name="phoneNumber" id="phoneNumber" style="flex: 1;">
                            </div>
                        </div>

<!--                        <br>
                        <p class="password-text" style="text-align: center;">By pressing the pay button, you will be officially charged if the payment is successful..</p>
                        <br>-->
                        
                        <button type="submit">Pay</button>
                    </form>
                </div>
                
            </div>
        </div>
        <div style="text-align: center; margin-top: 20px;">
            <a href="${pageContext.request.contextPath}/select_payment_method?error=payment_faile" style="margin-right: 40px; text-decoration: underline;">Payment Error</a>

            <a href="${pageContext.request.contextPath}/find_table?error=out_of_table" style="text-decoration: underline;">Out of Tables</a>
        </div>
        <!-- Footer -->
        <%@ include file="cus_footer.jspf" %>
    </div>
    
</body>
</html>
