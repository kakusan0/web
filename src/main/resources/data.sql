INSERT
INTO postmaster(LeftPostCode, RightPostCode)
SELECT IF(LENGTH(a.PostCode) < 6, LEFT(a.PostCode, 4), LEFT(a.PostCode, 3))
     , IF(LENGTH(a.PostCode) > 6, RIGHT(a.PostCode, 4), RIGHT(a.PostCode, 3))
FROM temppostmaster a;