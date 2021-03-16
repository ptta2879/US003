/**
 * 
 */
Notiflix.Loading.Init({messageColor:'#fff',svgSize:'100px',clickToClose:true,});
 Notiflix.Report.Init({
        svgSize:'90px',
        plainText:false,
        messageMaxLength:10000,
        messageFontSize: '16px',
        buttonFontSize:'16px',
        messageMaxLength:10000,
    });
appCalculator ={
	ajaxCal: function() {
		Notiflix.Loading.Standard('Loading...');
		let effectiveDate = $("#effectivedate").val().toString();
		let expiryDate = $("#expirydate").val().toString();
		let sumInsured = $("#suminsured").val().toString();
		let rate = $("#rate").val().toString();
		let annualPremium = $("#annualpremium").val().toString();
		let postedPremium = $("#postedpremium").val().toString();
		let policyNo =$("#policyno").val().toString();
		let policyOwner =$("#policyowner").val().toString();
		let enghineNo =$("#enghineno").val().toString();
		let chassicNo =$("#chassicno").val().toString();
		let vehicleRegistrationRo =$("#vehicleregistrationno").val().toString();
		let inceptionDate =$("#inceptiondate").val().toString();
		if(!effectiveDate || !expiryDate|| !sumInsured || !rate || !annualPremium  || !postedPremium || !policyNo ||!policyOwner||!enghineNo||!chassicNo||!vehicleRegistrationRo ||!inceptionDate ){
			 Notiflix.Report.Failure( 'ERROR', 'Error did not enter all information', 'OK' ); 
			Notiflix.Loading.Remove();
		}else{
			$.ajax({
			type:"GET",
			data: {
					inceptionDate:inceptionDate,
					effectiveDate:effectiveDate,
					expiryDate: expiryDate,
					sumInsured:sumInsured,
					rate:rate,
					annualPremium:annualPremium,
					},
			url:"RefeshPage",
			success: function(result) {
					if(result[0] == "DateErr" ){
						Notiflix.Report.Failure( 'ERROR', 'Invalid effective date (Effective date must be within POI) ', 'OK',function(){Notiflix.Loading.Remove();} );
					}
					else{
						$("#annualpremium").val(result[0]);
						$("#postedpremium").val(result[1]);
						Notiflix.Notify.Success('Success');
						Notiflix.Loading.Remove(600);
					}
					
			}
			
		});
		}
	},
	ajaxSave: function(){
		Notiflix.Loading.Standard('Loading...');
		let effectiveDate = $("#effectivedate").val().toString();
		let expiryDate = $("#expirydate").val().toString();
		let sumInsured = $("#suminsured").val().toString();
		let rate = $("#rate").val().toString();
		let annualPremium = $("#annualpremium").val().toString();
		let postedPremium = $("#postedpremium").val().toString();
		let policyNo =$("#policyno").val().toString();
		let enghineNo =$("#enghineno").val().toString();
		let chassicNo =$("#chassicno").val().toString();
		let vehicleRegistrationNo =$("#vehicleregistrationno").val().toString();
		let inceptionDate =$("#inceptiondate").val().toString();
		let billing =$("#billing").val().toString();
		if(!effectiveDate || !expiryDate|| !sumInsured || !rate || !annualPremium  || !postedPremium || !policyNo ||!enghineNo||!chassicNo||!vehicleRegistrationNo || !inceptionDate|| !billing){
			Notiflix.Report.Failure( 'ERROR', 'Error did not enter all information', 'OK' ); 
			Notiflix.Loading.Remove();
		}else{
			 Notiflix.Confirm.Show( 'Notification', 'Do you want create endorsement', 'Yes', 'No', function(){  
				$.ajax({
				type :"POST",
				data: {
					inceptionDate:inceptionDate,
					effectiveDate:effectiveDate,
					expiryDate: expiryDate,
					sumInsured:sumInsured,
					rate:rate,
					annualPremium:annualPremium,
					postedPremium:postedPremium,
					policyNo:policyNo,
					enghineNo:enghineNo,
					chassicNo:chassicNo,
					vehicleRegistrationNo:vehicleRegistrationNo,
					billing:billing
					},
				url:"RefeshPage",
				success: function(result){
					if(result[0] == "DataErr"){
						Notiflix.Report.Failure( 'ERROR', 'Error did not enter all information', 'OK' ); 
						Notiflix.Loading.Remove();
					}else{
						if(result[0] == "UpdateSuccess"){
							 Notiflix.Report.Success( 'Endorsement Create Success', 'Endorsement of Motor policy is saved successfully', 'Click', function(){Notiflix.Loading.Remove(600);window.location="Home"} ); 
						}else{
							Notiflix.Notify.Failure('Fail (Chassis and Engine number duplication or Sum Insured and Rate is negative )');
							Notiflix.Loading.Remove(600);
						}
					}
				}
			});
			 }); 
			
		}
	}
}