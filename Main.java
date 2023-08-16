import java.util.ArrayList;
import java.util.List;
import java.awt.Image;

class ModelStore {
    private List<PoligonalModel> models;

    public ModelStore() {
        models = new ArrayList<>();
    }

    public void addModel(PoligonalModel model) {
        models.add(model);
    }

    public void removeModel(PoligonalModel model) {
        models.remove(model);
    }

    public List<PoligonalModel> getModels() {
        return models;
    }
}

class PoligonalModel {
    private String name;
    private List<Polygon> polygons;
    private List<Texture> textures;

    public PoligonalModel(String name) {
        this.name = name;
        polygons = new ArrayList<>();
        textures = new ArrayList<>();
    }

    public void addPolygon(Polygon polygon) {
        polygons.add(polygon);
    }

    public void removePolygon(Polygon polygon) {
        polygons.remove(polygon);
    }

    public void addTexture(Texture texture) {
        textures.add(texture);
    }

    public void removeTexture(Texture texture) {
        textures.remove(texture);
    }

    public List<Polygon> getPolygons() {
        return polygons;
    }

    public List<Texture> getTextures() {
        return textures;
    }
}

class Texture {
    private String name;
    private Image data;

    public Texture(String name, Image data) {
        this.name = name;
        this.data = data;
    }
}

class Polygon {
    private List<Point> points;

    public Polygon() {
        points = new ArrayList<>();
    }

    public void addPoint(Point point) {
        points.add(point);
    }

    public void removePoint(Point point) {
        points.remove(point);
    }

    public List<Point> getPoints() {
        return points;
    }
}

class Flash {
    private String file;
    private int width;
    private int height;

    public Flash(String file, int width, int height) {
        this.file = file;
        this.width = width;
        this.height = height;
    }

    public void play() {
        System.out.println("Playing...");
    }

    public void stop() {
        System.out.println("Stopped.");
    }
}

class Camera {
    private int width;
    private int height;
    private int fov;

    public Camera(int width, int height, int fov) {
        this.width = width;
        this.height = height;
        this.fov = fov;
    }

    public void setPosition(Point position) {
        System.out.println("Camera position set to " + position.toString());
    }

    public void setLookAt(Point lookAt) {
        System.out.println("Camera lookat direction set to " + lookAt.toString());
    }

    public void setFov(int fov) {
        System.out.println("Camera FOV set to " + fov + " degrees");
    }
}

class Scene {
    private List<PoligonalModel> models;
    private Camera camera;
    private Flash flash;

    public Scene() {
        models = new ArrayList<>();
        camera = null;
        flash = null;
    }

    public void addModel(PoligonalModel model) {
        models.add(model);
    }

    public void removeModel(PoligonalModel model) {
        models.remove(model);
    }

    public void setCamera(Camera camera) {
        this.camera = camera;
    }

    public void setFlash(Flash flash) {
        this.flash = flash;
    }

    public void render() {
        System.out.println("Rendering scene...");
    }
}

class Point {
    private double x;
    private double y;
    private double z;

    public Point(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }
}

class Program {
    public static void main(String[] args) {
        Point p1 = new Point(0.0, 0.0, 0.0);
        Point p2 = new Point(1.0, 0.0, 0.0);
        Point p3 = new Point(1.0, 1.0, 0.0);
        Point p4 = new Point(0.0, 1.0, 0.0);

        Polygon square = new Polygon();
        square.addPoint(p1);
        square.addPoint(p2);
        square.addPoint(p3);
        square.addPoint(p4);

        Image image = new java.awt.image.BufferedImage(1, 1, java.awt.image.BufferedImage.TYPE_INT_RGB); // Adding an example of Image instance
        Texture texture = new Texture("square_texture", image);

        PoligonalModel model = new PoligonalModel("square");
        model.addPolygon(square);
        model.addTexture(texture);

        Flash flash = new Flash("square.swf", 800, 600);
        Camera camera = new Camera(800, 600, 90);

        Scene scene = new Scene();
        scene.addModel(model);
        scene.setCamera(camera);
        scene.setFlash(flash);
        scene.render();

        flash.play();
        camera.setPosition(new Point(0.0, 0.0, 1.0));
        camera.setLookAt(new Point(0.0, 0.0, 0.0));
    }
}