public class Vector3D {
  private float x;
  private float y;
  private float z;

  Vector3D(float x_, float y_, float z_) {
    x = x_;
    y = y_;
    z = z_;
  }

  float x() {
    return x;
  }

  float y() {
    return y;
  }
  
  float z() {
    return z;
  }

  void setX(float x_) {
    x = x_;
  }

  void setY(float y_) {
    y = y_;
  }

  void setZ(float z_) {
    z = z_;
  }
  
  void setXYZ(float x_, float y_, float z_) {
    x = x_;
    y = y_;
    z = z_;
  }

  void setXYZ(Vector3D v) {
    x = v.x();
    y = v.y();
    z = v.z();
  }
  public float magnitude() {
    return (float) Math.sqrt(x*x + y*y + z*z);
  }

  public Vector3D copy() {
    return new Vector3D(x,y,z);
  }

  public static Vector3D copy(Vector3D v) {
    return new Vector3D(v.x(), v.y(),v.z());
  }

  public void add(Vector3D v) {
    x += v.x;
    y += v.y;
    z += v.z;
  }

  public void sub(Vector3D v) {
    x -= v.x;
    y -= v.y;
    z -= v.z;
  }

  public void mult(float n) {
    x *= n;
    y *= n;
    z *= n;
  }

  public void div(float n) {
    x /= n;
    y /= n;
    z /= n;
  }

  public void normalize() {
    float m = magnitude();
    if (m > 0) {
       div(m);
    }
  }

  public void limit(float max) {
    if (magnitude() > max) {
      normalize();
      mult(max);
    }
  }

  public float heading2D() {
    float angle = (float) Math.atan2(-y, x);
    return -1*angle;
  }

  public static Vector3D add(Vector3D v1, Vector3D v2) {
    Vector3D v = new Vector3D(v1.x() + v2.x(),v1.y() + v2.y(), v1.z() + v2.z());
    return v;
  }

  public static Vector3D sub(Vector3D v1, Vector3D v2) {
    Vector3D v = new Vector3D(v1.x() - v2.x(),v1.y() - v2.y(),v1.z() - v2.z());
    return v;
  }

  public static Vector3D div(Vector3D v1, float n) {
    Vector3D v = new Vector3D(v1.x()/n,v1.y()/n,v1.z()/n);
    return v;
  }

  public static Vector3D mult(Vector3D v1, float n) {
    Vector3D v = new Vector3D(v1.x()*n,v1.y()*n,v1.z()*n);
    return v;
  }

  public static float distance (Vector3D v1, Vector3D v2) {
    float dx = v1.x() - v2.x();
    float dy = v1.y() - v2.y();
    float dz = v1.z() - v2.z();
    return (float) Math.sqrt(dx*dx + dy*dy + dz*dz);
  }

}

