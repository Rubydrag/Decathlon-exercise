<?xml version="1.0"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="html" encoding="UTF-8"/>
<xsl:template match="/">
<html>
<head><title>Decathlon Competition</title>
</head>
<body>
<table width="100%" border="1">
  <THEAD>
           <TR>
                <TD width="35%"><B>ATHLETE NAME</B></TD>
                <TD width="15%"><B>TOTAL POINTS</B></TD>
                <TD width="10%"><B>RANK</B></TD>
                <TD width="10%"><B>100M</B></TD>
                <TD width="10%"><B>110M Hurdles</B></TD>
                <TD width="10%"><B>400M</B></TD>
                <TD width="10%"><B>1500M</B></TD>
                <TD width="10%"><B>LONG JUMP</B></TD>
                <TD width="10%"><B>SHOT PUT</B></TD>
                <TD width="10%"><B>HIGH JUMP</B></TD>
                <TD width="10%"><B>DISCUS THROW</B></TD>
                <TD width="10%"><B>JAVELIN THROW</B></TD>
                <TD width="10%"><B>POLE JUMP</B></TD>
          </TR>
   </THEAD> 
  <TBODY>
             <xsl:for-each select="athletes/Athlete">
             <TR> 
                  <TD width="35%"><xsl:value-of select="Name" /></TD>   
                  <TD width="15%"><xsl:value-of select="Total_POINTS" /></TD> 
                  <TD width="10%"><xsl:value-of select="Rank" /></TD>
                  <TD width="10%"><xsl:value-of select="points/Track_100M" /></TD>
                  <TD width="10%"><xsl:value-of select="points/Track_110M_Hurdles" /></TD>
                  <TD width="10%"><xsl:value-of select="points/Track_400M" /></TD>
                  <TD width="10%"><xsl:value-of select="points/Track_1500M" /></TD>
                  <TD width="10%"><xsl:value-of select="points/Long_Jump" /></TD>
                  <TD width="10%"><xsl:value-of select="points/Shot_PUT" /></TD>
                  <TD width="10%"><xsl:value-of select="points/High_Jump" /></TD>
                  <TD width="10%"><xsl:value-of select="points/Discus_Throw" /></TD>
                  <TD width="10%"><xsl:value-of select="points/Javelin_Throw" /></TD>
                  <TD width="10%"><xsl:value-of select="points/Pole_Jump" /></TD> 
             </TR>
            </xsl:for-each>
  </TBODY>
</table>
</body>
</html>
</xsl:template>
</xsl:stylesheet>