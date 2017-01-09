CREATE OR REPLACE FUNCTION Distance(
    Lat1   IN NUMBER,
    Lon1   IN NUMBER,
    Lat2   IN NUMBER,
    Lon2   IN NUMBER,
    Radius IN NUMBER DEFAULT 3963)
  RETURN NUMBER
IS
  -- Convert degrees to radians
  DegToRad NUMBER := 57.29577951;
BEGIN
  RETURN(NVL(Radius,0) * ACOS((sin(NVL(Lat1,0) / DegToRad) * SIN(NVL(Lat2,0) / DegToRad)) + (COS(NVL(Lat1,0) / DegToRad) * COS(NVL(Lat2,0) / DegToRad) * COS(NVL(Lon2,0) / DegToRad - NVL(Lon1,0)/ DegToRad))));
EXCEPTION
WHEN OTHERS THEN
  RETURN 0;
END;
