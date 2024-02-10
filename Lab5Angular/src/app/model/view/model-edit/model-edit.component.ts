import {Component, OnInit} from '@angular/core';
import {ModelForm} from "../../model/model-form";
import {ModelService} from "../../service/model.service";
import {ActivatedRoute, Router} from "@angular/router";


@Component({
  selector: 'app-model-edit',
  templateUrl: './model-edit.component.html',
  styleUrls: ['./model-edit.component.css', '../../../forms.css']
})
export class ModelEditComponent implements OnInit{

  uuid: string | undefined;

  model: ModelForm | undefined;

  original: ModelForm | undefined;

  constructor(
      private modelService: ModelService,
      private route: ActivatedRoute,
      private router: Router

  ) {
  }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.modelService.getModel(params['modelsUuid'])
          .subscribe(model => {
            this.uuid = params['modelsUuid']
            this.model = {
              name: model.name,
              announceYear: model.announceYear,
              price: model.price,
              brand: model.brand
            };
            this.original = {...this.model};
          });
    });
  }

  onSubmit(): void {
    this.route.params.subscribe(params => {
    this.modelService.patchModel(this.uuid!, this.model!)
        .subscribe(() => this.router.navigate(['/brands/'+ params['brandsUuid']]))
  });
  }

}
