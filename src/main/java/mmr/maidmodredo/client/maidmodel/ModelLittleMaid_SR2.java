package mmr.maidmodredo.client.maidmodel;


import mmr.maidmodredo.api.IMaidAnimation;
import mmr.maidmodredo.entity.LittleMaidBaseEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;

/**
 * 瞬き付き基本形
 */
public class ModelLittleMaid_SR2<T extends LivingEntity> extends ModelLittleMaidBase<T> {

	public MaidRendererModel eyeR;
	public MaidRendererModel eyeL;


	public ModelLittleMaid_SR2() {
		super();
	}
	public ModelLittleMaid_SR2(float psize) {
		super(psize);
	}
	public ModelLittleMaid_SR2(float psize, float pyoffset, int pTextureWidth, int pTextureHeight) {
		super(psize, pyoffset, pTextureWidth, pTextureHeight);
	}


	@Override
	public void initModel(float psize, float pyoffset) {
		super.initModel(psize, pyoffset);

		//TODO
		// 追加パーツ
		eyeR = new MaidRendererModel(this, 32, 19);
		eyeR.addBox(-4.0F, -5.0F, -4.001F, 4, 4, 0, psize);
		eyeR.setRotationPoint(0.0F, 0.0F, 0.0F);
		eyeL = new MaidRendererModel(this, 42, 19);
		eyeL.addBox(0.0F, -5.0F, -4.001F, 4, 4, 0, psize);
		eyeL.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedHead.addChild(eyeR);
		bipedHead.addChild(eyeL);
	}

	@Override
	public void setLivingAnimations(IModelCaps pEntityCaps, float par2, float par3, float pRenderPartialTicks) {
		super.setLivingAnimations(pEntityCaps, par2, par3, pRenderPartialTicks);
		
		float f3 = entityTicksExisted + pRenderPartialTicks + entityIdFactor;

        Entity entity = (Entity) pEntityCaps.getCapsValue(IModelCaps.caps_Entity);

		// 目パチ
        if (entity instanceof LivingEntity && ((LivingEntity) entity).isSleeping()) {
            eyeR.setVisible(true);
            eyeL.setVisible(true);
        } else if (0 > mh_sin(f3 * 0.05F) + mh_sin(f3 * 0.13F) + mh_sin(f3 * 0.7F) + 2.55F) {
			eyeR.setVisible(true);
			eyeL.setVisible(true);
		} else { 
			eyeR.setVisible(false);
			eyeL.setVisible(false);
		}
	}

	@Override
	public void setRotationAngles(float par1, float par2, float pTicksExisted,
			float pHeadYaw, float pHeadPitch, float par6, IModelCaps pEntityCaps) {
		super.setRotationAngles(par1, par2, pTicksExisted, pHeadYaw, pHeadPitch, par6, pEntityCaps);
		if (aimedBow) {
			if (ModelCapsHelper.getCapsValueInt(pEntityCaps, caps_dominantArm) == 0) {
				eyeL.setVisible(true);
			} else {
				eyeR.setVisible(true);
			}
		}
	}

    @Override
    public void setAnimations(float par1, float par2, float pTicksExisted, float pHeadYaw, float pHeadPitch, float par6, IModelCaps pEntityCaps, IMaidAnimation animation) {
        super.setAnimations(par1, par2, pTicksExisted, pHeadYaw, pHeadPitch, par6, pEntityCaps, animation);

        if (animation.getAnimation() == LittleMaidBaseEntity.PET_ANIMATION) {

        }
    }

	@Override
	public String getUsingTexture() {
		return null;
	}

}
