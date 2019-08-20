package com.juiceman.ihatehibernate.ihatehiberatedemo.model;


import javax.persistence.*;


@NamedNativeQueries({
        @NamedNativeQuery(name = "find_all_spaceships",
                query =
                        "SELECT " +
                                "   name as \"name\", " +
                                "   model, " +
                                "   speed, " +
                                "   lname as lastn, " +
                                "   fname as firstn, " +
                                "   length, " +
                                "   width, " +
                                "   length * width as surface, " +
                                "   length * width * 10 as volume " +
                                "FROM SpaceShip",
                resultSetMapping = "spaceship"
        )
})
@SqlResultSetMapping(
        name = "spaceship",
        entities = @EntityResult(
                entityClass = SpaceShip.class,
                fields = {
                        @FieldResult(name = "name", column = "name"),
                        @FieldResult(name = "model", column = "model"),
                        @FieldResult(name = "speed", column = "speed"),
                        @FieldResult(name = "captain.lastname", column = "lastn"),
                        @FieldResult(name = "captain.firstname", column = "firstn"),
                        @FieldResult(name = "dimensions.length", column = "length"),
                        @FieldResult(name = "dimensions.width", column = "width"),
                }
        ),
        columns = {
                @ColumnResult(name = "surface"),
                @ColumnResult(name = "volume")
        }
)



@Entity(name = "SpaceShip")
@Table(name = "SpaceShip")
public class SpaceShip {

    @Id
    private String name;

    private String model;

    private double speed;

    public SpaceShip(){
        super();
    }


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "fname", referencedColumnName = "firstname"),
            @JoinColumn(name = "lname", referencedColumnName = "lastname")
    })
    private Captain captain;

    private Dimensions dimensions;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public Captain getCaptain() {
        return captain;
    }

    public void setCaptain(Captain captain) {
        this.captain = captain;
    }

    public Dimensions getDimensions() {
        return dimensions;
    }

    public void setDimensions(Dimensions dimensions) {
        this.dimensions = dimensions;
    }
}