import { NgModule } from '@angular/core';
import {RouterModule, Routes} from "@angular/router";
import {BrandListComponent} from "./brand/view/brand-list/brand-list.component";
import {BrandViewComponent} from "./brand/view/brand-view/brand-view.component";
import {BrandEditComponent} from "./brand/view/brand-edit/brand-edit.component";
import {BrandCreateComponent} from "./brand/view/brand-create/brand-create.component";
import {ModelListComponent} from "./model/view/model-list/model-list.component";
import {ModelViewComponent} from "./model/view/model-view/model-view.component";
import {ModelCreateComponent} from "./model/view/model-create/model-create.component";
import {ModelEditComponent} from "./model/view/model-edit/model-edit.component";

const routes: Routes = [
  {
    component: BrandListComponent,
    path: "brands"
  },
  {
    component: BrandViewComponent,
    path: "brands/:uuid"
  },
  {
    component: BrandEditComponent,
    path: "brands/:uuid/edit"
  },
  {
    component: BrandCreateComponent,
    path: "brands-create"
  },
  {
    component: ModelListComponent,
    path: "brands/:uuid/models"
  },
  {
    component: ModelViewComponent,
    path: "models/:uuid"
  },
  {
    component: ModelCreateComponent,
    path: "models-create/:brandsUuid"
  },
  {
    component: ModelEditComponent,
    path: "brands/:brandsUuid/models/:modelsUuid/edit"
  }
];
@NgModule({
  declarations: [],
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule { }
