
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="html" indent="yes" />
<xsl:template match="/">
	<html>
    	<head>
			<style>
			table{
    			font-family: arial;
    			border="1";
    			border-collapse: collapse;
    			width: 100%;
				}
				td,th{	
					style="font-size:20px;"
    				border: 1px solid #dddddd;
    				text-align: left;
    			}
    			tr:nth-child(even) {
   				background-color: powder blue;�
			}
		</style>
		</head>
		<body>
			<table>
				<th>Hospital ID</th>
				<th>Name</th>
				<th>Location</th>
				<th>Medical Specialization</th>
				<th>Order</th>
				<xsl:for-each select="Hospital/Orders/Order">
				<xsl:sort select="@orderID" data-type="number"/>
					<tr>
           	 			<td><xsl:value-of select = "@orderID"/></td>
            			<td><xsl:value-of select = "totalAmountInstruments"/></td>
						<td><xsl:value-of select = "orderDate"/></td>
	 					<td><xsl:value-of select = "deliveryDate"/></td>
            		</tr>
    			</xsl:for-each>    
			</table>
		</body>
	</html>
</xsl:template>
</xsl:stylesheet>
