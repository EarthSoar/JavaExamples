package case2;

public class ActorController {
    public Actor construct(ActorBuilder ab) {
        ab.BuildType();
        ab.BuildSex();
        ab.BuildFace();
        ab.BuildCostume();
        ab.BuildHairstyle();
        return ab.createActor();
    }
}
