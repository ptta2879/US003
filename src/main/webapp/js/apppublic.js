/**
 * 
 */

Notiflix.Notify.Init({position:"right-bottom",});
   Notiflix.Report.Init({
        svgSize:'90px',
        plainText:false,
        messageMaxLength:200,
        messageFontSize: '16px',
        buttonFontSize:'16px',
        messageMaxLength:500,
    });
var dienra = $("#update-modal .modal-body #remove");

            $(".btn-icon").on("click", function () {
                // console.log(this);
                var myValue = $(this).data('val');
                // $(".modal-body #bookId").val( myBookId );

                var obj = $("#update-modal");

                $(obj).find(".modal-body #add").append(dienra);

                if(myValue.trangthai == 1){
                    $(obj).find(".modal-body #add #customRadio1").prop( "checked", true );
                }
                else{
                    $(obj).find(".modal-body #add #customRadio2").prop( "checked", true );
                }
            
                $(obj).find(".modal-header .modal-title").text("Policy Number " + myValue.policyNo);
                $(obj).find(".modal-footer #create").text("Issue");
                $(obj).find(".modal-footer #create").prop('value', '');
               
                $(obj).find(".modal-body #policyno").prop( "readonly", true );
                $(obj).find(".modal-body #policyowner").prop( "readonly", true );
                $(obj).find(".modal-body #policyno").val(myValue.policyNo);
                $(obj).find(".modal-body #inceptiondate").val(myValue.inceptionDate);
                $(obj).find(".modal-body #effectivedate").val(myValue.effectiveDate);
                $(obj).find(".modal-body #expirydate").val(myValue.expiryDate);
                $(obj).find(".modal-body #policyowner").val(myValue.policyOwner);
				$(obj).find(".modal-body #enghineno").val(myValue.engineNo);
				$(obj).find(".modal-body #chassicno").val(myValue.chasisNo);
				$(obj).find(".modal-body #vehicleregistrationno").val(myValue.vehicleRegistrationNo);
				$(obj).find(".modal-body #billing").val(myValue.billingCurrency);
				$(obj).find(".modal-body #suminsured").val(myValue.sumInsured);
				$(obj).find(".modal-body #rate").val(myValue.rate);
				$(obj).find(".modal-body #annualpremium").val(myValue.annualPremium);
				$(obj).find(".modal-body #postedpremium").val(myValue.postedPremium);

            });