puts "{{> top.hbs}}"
puts "<div class=\"container\">"
puts "    <h1 style=\"text-align: center\">Application to Rent</h1>"

### End Top Matter

row = 0
[[3, "Last Name", "lastName"],
[3, "First Name", "firstName"],
[3, "Middle Name", "middleName"],
[3, "Social Security", "ssn"],

[4, "Other Names used", "otherNames"],
[4, "Date of Birth", "dob"],
[4, "Email", "email"],

[4, "Mobile/Cell phone", "cellPhone"],
[4, "Home phone", "homePhone"],
[4, "Work phone", "workPhone"],

[3, "Photo ID/Type", "idType"],
[3, "Number", "idNumber"],
[3, "Issuing government", "idIssuer"],
[3, "Exp. date", "idExp"],

"<hr>",

[4, "Present address", "addr1-street"],
[4, "City", "addr1-city"],
[2, "State", "addr1-state"],
[2, "Zip", "addr1-zip"],

[3, "Date in", "addr1-in"],
[3, "Date out", "addr1-out"],
[3, "Owner/Agent Name", "addr1-landlord"],
[3, "Owner/Agent Phone", "addr1-phone"],

[8, "Reason for moving out", "addr1-reason"],
[4, "Current rent", "addr1-rent"],

"<hr>",

[4, "Previous address", "addr2-street"],
[4, "City", "addr2-city"],
[2, "State", "addr2-state"],
[2, "Zip", "addr2-zip"],

[3, "Date in", "addr2-in"],
[3, "Date out", "addr2-out"],
[3, "Owner/Agent Name", "addr2-landlord"],
[3, "Owner/Agent Phone", "addr2-phone"],

[12, "Reason for moving out", "addr2-reason"],

"<hr>",

[4, "Next previous address", "addr3-street"],
[4, "City", "addr3-city"],
[2, "State", "addr3-state"],
[2, "Zip", "addr3-zip"],

[3, "Date in", "addr3-in"],
[3, "Date out", "addr3-out"],
[3, "Owner/Agent Name", "addr3-landlord"],
[3, "Owner/Agent Phone", "addr3-phone"],

[12, "Reason for moving out", "addr3-reason"],

"<hr>",

[12, "Proposed occupants", "occupants"],

[4, "Do you have pets?", "pets"],
[8, "Describe", "describePets"],
[4, "Do you have a waterbed?", "waterbed"],
[8, "Describe", "describeWaterbed"],

[12, "How did you hear about this rental?", "hearAbout"],

"<hr>",

[4, "Current Employer Name", "emp1-name"],
[4, "Job Title or Position", "emp1-title"],
[4, "Dates of Employment", "emp1-dates"],

[6, "Employer address", "emp1-address"],
[6, "Employer/HR phone number", "emp1-phone"],

[6, "City, State, Zip", "emp1-cityStateZip"],
[6, "Name of supervisor/HR manager", "emp1-supervisor"],

[12, "Current gross income", "emp1-income"],

"<hr>",

[4, "Prior Employer Name", "emp2-name"],
[4, "Job Title or Position", "emp2-title"],
[4, "Dates of Employment", "emp2-dates"],

[6, "Employer address", "emp2-address"],
[6, "Employer/HR phone number", "emp2-phone"],

[6, "City, State, Zip", "emp2-cityStateZip"],
[6, "Name of supervisor/HR manager", "emp2-supervisor"],

"<hr>",

[12, "Other Income", "otherIncome"],

"<hr>",

[4, "Name of your bank", "bankName"],
[4, "Branch or address", "bankBranch"],
[4, "Account Number", "bankAccountNumber"],

"<hr>",

"List of all financial obligations",

[3, "Name of Creditor", "debt1-creditor"],
[3, "Address", "debt1-address"],
[3, "Phone", "debt1-phone"],
[3, "Monthly Payment", "debt1-payment"],

[3, "Name of Creditor", "debt2-creditor"],
[3, "Address", "debt2-address"],
[3, "Phone", "debt2-phone"],
[3, "Monthly Payment", "debt2-payment"],

[3, "Name of Creditor", "debt3-creditor"],
[3, "Address", "debt3-address"],
[3, "Phone", "debt3-phone"],
[3, "Monthly Payment", "debt3-payment"],

"<hr>",
"In case of emergency, notify:",

[3, "Name", "emergency1-name"],
[3, "Address", "emergency1-address"],
[3, "Relationship", "emergency1-relation"],
[3, "Phone", "emergency1-phone"],

[3, "Name", "emergency2-name"],
[3, "Address", "emergency2-address"],
[3, "Relationship", "emergency2-relation"],
[3, "Phone", "emergency2-phone"],

"<hr>",
"Personal References:",

[3, "Name", "reference1-name"],
[3, "Address", "reference1-address"],
[2, "Length of Acquaintance", "reference1-length"],
[2, "Occupation", "reference1-occupation"],
[2, "Phone", "reference1-phone"],

[3, "Name", "reference2-name"],
[3, "Address", "reference2-address"],
[2, "Length of Acquaintance", "reference2-length"],
[2, "Occupation", "reference2-occupation"],
[2, "Phone", "reference2-phone"],

"<hr>",

[3, "Automobile: Make", "car1-make"],
[3, "Model", "car1-model"],
[3, "Year", "car1-year"],
[3, "License Number", "car1-plates"],

[3, "Automobile: Make", "car2-make"],
[3, "Model", "car2-model"],
[3, "Year", "car2-year"],
[3, "License Number", "car2-plates"],

"<hr>",

[12, "Have you ever filed for bankruptcy?", "bankruptcy"],
[12, "Have you ever been evicted or asked to move?", "evicted"],
[12, "Have you ever been convicted of selling, distributing or manufacturing illegal drugs?", "drugs"]

].each do |field|
 if field.is_a? Array
  size = field[0]
  name = field[1]
  value = field[2]

  if name.end_with? "?"
    name = name + " "
  else
    name = name + ": "
  end

  if row == 0
    puts "<div class=\"row\">"
  end
 
  row += size
  puts "  <div class=\"col-xs-#{size}\"><small>#{name}</small><p>{{#{value}}}</p></div>"

  if row >= 12
    puts "</div>"
    row = 0
  end
 
  else # should be a string, just print it
    puts "<div>#{field}</div>"
  end
end

### Start Bottom Matter
puts "<hr>"
puts "<div><small>This rental application was prepared at rentshape.com</small></div>"
puts "</div>"
puts "{{> bottom.hbs}}"
